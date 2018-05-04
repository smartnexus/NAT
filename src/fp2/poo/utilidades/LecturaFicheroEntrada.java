/*
 *  @(#)LecturaFicheroEntrada.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 */
 
package fp2.poo.utilidades;

import fp2.poo.pfpooangrodboh.Paquete;
import fp2.poo.pfpooangrodboh.Puerto;
import fp2.poo.pfpooangrodboh.Datos;
import fp2.poo.pfpooangrodboh.Ist;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

import fp2.poo.utilidades.Excepciones.PuertoIncorrectoExcepcion;

/*
 * En esta clase se realiza la lectura de los ficheros y se crean los objetos
 * que maneja el programa con la informacion obtenida dichos los ficheros.
 *
 * El nombre del fichero se proporcionan como constructor de la clase.
 * Estos ficheros se busca en el directorio "./ficherosEntrada/".
 *
 * Esta clase implementa los dos metodos de la interfaz Iteracion.
 *
 * La clase usa los constructores de la implementacion realizada por
 * el alumno. Para poder usarla deberá cambiar pfpoofp2 por pfpooXXX
 * donde XXX es el uvus del alumno, en las siguientes importaciones.
 *
 * import fp2.poo.pfpooangrodboh.Paquete;
 * import fp2.poo.pfpooangrodboh.Puerto;
 * import fp2.poo.pfpoofp2.Datos;
 * import fp2.poo.pfpooangrodboh.Ist;
 *
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II 
 */
public class LecturaFicheroEntrada implements Iterator<PaqueteInterfaz> {

 	/** in es el atributo usado para realizar la lectura buferada del fichero. */
    private BufferedReader in = null;

 	/** paquete es el atributo que representa el paquete que se lee del fichero de entrada. */	
    private PaqueteInterfaz paquete = null;
	
	/** ruta es el atributo que indica donde se almacenan los ficheros de entrada. */	
    private String ruta = "./datos/";

	/*
	 * Constructor de la clase. En este constructor se realiza la apertura 
	 * del flujo de entrada para realizar la lectura.
	 * @param nombreDelFichero es un objeto de tipo String con el nombre del fichero de entrada.
	 */	
    public LecturaFicheroEntrada(String nombreDelFichero) {
        try{
            in = new BufferedReader (new InputStreamReader(new FileInputStream(ruta + nombreDelFichero)));
        } catch (FileNotFoundException e) {
            System.out.println("Error en apertura de fichero.");
        }
    }  

	/*
	 * Realiza el cierre el flujo asociado al fichero de entrada.
	 */		
    public void terminaLectura() {
	    try  {
	        this.in.close();
		} catch(IOException e) {
	        System.err.println("Error en termina Lectura. (cierre del fichero)");
		}
	}

    /*
     *  Este metodo devuelve una referencia a un Paquete mediante PaqueteInterfaz.          
     */	
    public PaqueteInterfaz next() {
        if (paquete == null)
            return null;
        PaqueteInterfaz local  = paquete;
        paquete = null;
        return local;
    }
	
    /*
     *  Este metodo indica si hay otra objeto Paquete.
     *
     *  @return    Devuelve un valor del tipo boolean que indica
     *             si hay mas objetos del tipo Paquete.
     */	
    public boolean hasNext() {
        String linea;
        InetAddress direccionDestino;
		Puerto puertoDestino;
        InetAddress direccionOrigen;
		Puerto puertoOrigen;
        Datos datos;
        Ist istDestino;
        Ist istOrigen;
		
        try{

            try {
			    linea = (in.readLine()).trim();
	     		direccionOrigen = InetAddress.getByName(linea);
            } catch (UnknownHostException e) {
			    direccionOrigen = null;
			}
			
            try {            
                linea = (in.readLine()).trim(); 			
                puertoOrigen = new Puerto(Integer.parseInt(linea));
            } catch (PuertoIncorrectoExcepcion e) {
			    puertoOrigen = null;
			}
			
            try {
			    linea = (in. readLine()).trim();
		        direccionDestino = InetAddress.getByName(linea);
		    } catch (UnknownHostException e){
			    direccionDestino = null;
		    }

            try {		
                linea = (in.readLine()).trim(); 
                puertoDestino = new Puerto(Integer.parseInt(linea));
            } catch (PuertoIncorrectoExcepcion e){
			    puertoDestino = null;
			}				
            linea = in.readLine().trim();
			datos = new Datos(linea);
			
            in.readLine();
            
            if(direccionOrigen != null && puertoOrigen != null && direccionDestino != null && puertoDestino != null)	{
                istOrigen = new Ist(direccionOrigen, puertoOrigen);
			    istDestino = new Ist(direccionDestino, puertoDestino);
                paquete = new Paquete(istOrigen, istDestino, datos);
			} else {
                System.err.println("Paquete de entrada incorrecto.");
			}

       } catch (IOException e) {
	        //System.out.println(e); 
            paquete = null;
       } catch (Exception e) {
	        //System.out.println(e);
	        paquete = null;
       }
       return (paquete != null);
    }
    
    public void remove(){
         // No hace nada
         //throw new UnsupportedOperationException();
    }
}

