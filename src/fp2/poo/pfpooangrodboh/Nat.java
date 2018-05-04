package fp2.poo.pfpooangrodboh;

import fp2.poo.utilidades.Excepciones.OperacionNoPermitidaExcepcion;
import fp2.poo.utilidades.Excepciones.PuertoIncorrectoExcepcion;
import fp2.poo.utilidades.IstInterfaz;
import fp2.poo.utilidades.LecturaFicheroEntrada;
import fp2.poo.utilidades.NatInterfaz;
import fp2.poo.utilidades.PaqueteInterfaz;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class Nat implements NatInterfaz {

    /** lectura es el atributo que es usado en la lectura del fichero de entrada.*/
    private LecturaFicheroEntrada lectura = null;
    /** tabla es el atributo usado para realizar la traduccion de direcciones.*/
    private Map<IstInterfaz,IstInterfaz> tablaTraduccion;
    /** numeroDeEntradas es el numero de registros en la tabla.*/
    private int numeroDeEntradas = 0;
    /** direccionExternaDelNat contiene la direccion externa del NAT. */
    InetAddress direccionExternaDelNat;
    /** numeroDePaquetesLlegados contiene el numero de paquetes llegados al NAT. */
    private int numeroDePaquetesLlegados = 0;

    public Nat(String direccionExterna) throws OperacionNoPermitidaExcepcion{

        tablaTraduccion = new HashMap<IstInterfaz,IstInterfaz>();
        try {
            direccionExternaDelNat = InetAddress.getByName(direccionExterna);
        } catch(UnknownHostException e){
            throw new OperacionNoPermitidaExcepcion("Direccion externa no valida.");
        }
    }

    /**
     * Muestra por la salida estandar todos los registros de la
     * tabla de traduccion.
     */
    @Override
    public void muestraRegistros() {
        for(IstInterfaz org : tablaTraduccion.keySet()) {
            IstInterfaz dest = tablaTraduccion.get(org);
            System.out.println(org.toString() + " - " + dest.toString() + ".");
        }
    }

    /**
     * Muestra por la salida estandar el contenido de un paquete.
     *
     * @param paquete es el paquete a mostrar.
     */
    @Override
    public void muestraPaquete(PaqueteInterfaz paquete) {
        System.out.println(paquete.getIstOrigen().toString());
        System.out.println(paquete.getIstDestino().toString());
        System.out.println(paquete.getDatos().getDatos());
    }

    /**
     * Realiza la traduccion de un paquete proporcionado.
     *
     * @param paquete es el paquete a traducir.
     */
    @Override
    public void traducePaquete(PaqueteInterfaz paquete) throws OperacionNoPermitidaExcepcion {
        byte[] org = paquete.getIstOrigen().getDireccion().getAddress(); //Descomponemos la dirección de origen en bytes.

        if(org[0] == NatInterfaz.PRIMER_BYTE_PRIVADO && org[1] == NatInterfaz.SEGUNDO_BYTE_PRIVADO) {
            // Comprobamos si esta es una dirección local mediante una igualación de la dirección de origen a cada byte de la clase NatInterfaz.
            // A partir de aquí ya tratamos esta transferencia desde el ámbito privado al público.

            IstInterfaz translation = null; //Inicializo el nuevo IST de origen.

            if (!tablaTraduccion.containsKey(paquete.getIstOrigen())) { //Compruebo que no existe una referencia para el origen en la tabla de traducciones.
                try {
                    // Le asigno una traduccion a la direccion privada y la guardo en la tabla, incrementando el numero de entradas.
                    // Rodeandolo de un try para la excepción del puerto erróneo.
                    translation = new Ist(direccionExternaDelNat, new Puerto(1025 + numeroDeEntradas));
                    tablaTraduccion.put(paquete.getIstOrigen(), translation);
                    numeroDeEntradas++;
                } catch (PuertoIncorrectoExcepcion e) {
                    e.printStackTrace();
                }
            } else {
                translation = tablaTraduccion.get(paquete.getIstOrigen()); //Existe la referencia la busco y la igualo al objeto que he creado anteriormente.
            }
            paquete.setIstOrigen(translation); //Cambio el origen del paquete para su posterior envío.

        } else {
            // A partir de aquí ya tratamos esta transferencia desde el ámbito público al privado.
            // Para empezar busco si la dirección de destino existe en mi tabla de traducción.
            boolean exception = true;
            for (Map.Entry<IstInterfaz, IstInterfaz> entry : tablaTraduccion.entrySet()) { // Para todas las entradas de la tabla.
                if (paquete.getIstDestino().getDireccion().equals(entry.getValue().getDireccion())  // Compruebo si alguna coincide con el Ist Destino
                    && paquete.getIstDestino().getPuerto().getPuerto() == (entry.getValue().getPuerto().getPuerto())) {
                    paquete.setIstDestino(entry.getKey()); // Si coincide la establezco como nuevo destino.
                    exception = false;
                }
            }
            if(exception) throw new OperacionNoPermitidaExcepcion("No se ha podido traducir el paquete.");
        }
    }

    /**
     * Elimina todos los registros de traduccion del NAT.
     */
    @Override
    public void eliminaRegistrosTraduccion() {
        tablaTraduccion.clear();
        numeroDeEntradas = 0;
    }

    /**
     * Obtiene el numero de paquetes llegados al NAT.
     */
    @Override
    public int getNumeroDePaquetesLlegados() {
        return numeroDePaquetesLlegados;
    }

    /**
     * Establece el numero de paquetes llegados al NAT.
     *
     * @param numeroDePaquetesLlegados
     */
    @Override
    public void setNumeroDePaquetesLlegados(int numeroDePaquetesLlegados) {
        this.numeroDePaquetesLlegados = numeroDePaquetesLlegados;
    }

    /**
     * Incrementa el numero de paquetes llegados al NAT.
     */
    @Override
    public void incrementaNumeroDePaquetesLlegados() {
        this.numeroDePaquetesLlegados++;
    }

    public void traduce(String nombreFichero) throws OperacionNoPermitidaExcepcion {
        lectura = new LecturaFicheroEntrada(nombreFichero);
        try {
            while(lectura.hasNext()){
                PaqueteInterfaz paquete = lectura.next();
                traducePaquete(paquete);
            }
            lectura.terminaLectura();
        } catch (OperacionNoPermitidaExcepcion e) {
            throw e; }
    }
}
