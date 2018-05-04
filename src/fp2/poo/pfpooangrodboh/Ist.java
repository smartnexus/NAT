package fp2.poo.pfpooangrodboh;

import fp2.poo.utilidades.IstInterfaz;
import fp2.poo.utilidades.PuertoInterfaz;

import java.net.InetAddress;

public class Ist implements IstInterfaz {

    private InetAddress direccion;
    private PuertoInterfaz puerto;

    public Ist(InetAddress direccion, PuertoInterfaz puerto) {
        this.direccion = direccion;
        this.puerto = puerto;
    }

    /**
     * Metodo que establece la direccion.
     *
     * @param direccion
     */
    @Override
    public void setDireccion(InetAddress direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que devuelve como InetAddress la direccion
     * .
     */
    @Override
    public InetAddress getDireccion() {
        return direccion;
    }

    /**
     * Metodo que establece el puerto.
     *
     * @param puerto
     */
    @Override
    public void setPuerto(PuertoInterfaz puerto) {
        this.puerto = puerto;
    }

    /**
     * Metodo que devuelve como PuertoInterfaz  el puerto.
     */
    @Override
    public PuertoInterfaz getPuerto() {
        return puerto;
    }

    /**
     * Metodo que devuelve dirección y puerto en un formato predeterminado.
     */
    @Override
    public String toString() {
        return this.getDireccion() + ":" + this.getPuerto().getPuerto();
    }
}
