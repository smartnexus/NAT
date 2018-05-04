/*
 *  @(#)NatInterfaz.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 */

 
package fp2.poo.utilidades;

import fp2.poo.utilidades.PaqueteInterfaz;
import fp2.poo.utilidades.Excepciones.OperacionNoPermitidaExcepcion;

/**
 * Esta interfaz mantiene los metodos y las constantes usadas por la clase Nat.
 *
 *                             
 * @version version 1.0 Abril 2014 (Modificado Abril 2018)
 * @author  Fundamentos de Programacion II
 */
public interface NatInterfaz {

    /**
     * Es el primer byte de una direccion privada
     */
	public final static byte PRIMER_BYTE_PRIVADO = (byte)172;
	
    /**
     * Es el segundo byte de una direccion privada.
     */	
	public final static byte SEGUNDO_BYTE_PRIVADO = (byte)16;
	
    /**
     * Muestra por la salida estandar todos los registros de la 
	 * tabla de traduccion.
     */
	 public void muestraRegistros ( );

    /**
     * Muestra por la salida estandar el contenido de un paquete.
	 *
	 * @param paquete es el paquete a mostrar.
     */
	public void muestraPaquete ( PaqueteInterfaz  paquete );	

    /**
     * Realiza la traduccion de un paquete proporcionado.
	 *
	 * @param paquete es el paquete a traducir.
     */
	public void traducePaquete ( PaqueteInterfaz  paquete ) throws OperacionNoPermitidaExcepcion;	

    /**
     * Elimina todos los registros de traduccion del NAT.
     */
	public void eliminaRegistrosTraduccion () ;

    /**
     * Obtiene el numero de paquetes llegados al NAT.
     */
	public int getNumeroDePaquetesLlegados() ;

    /**
     * Establece el numero de paquetes llegados al NAT.
     */	
	public void setNumeroDePaquetesLlegados(int numeroDePaquetesLlegados);
	
   /**
    * Incrementa el numero de paquetes llegados al NAT.
    */
	public void incrementaNumeroDePaquetesLlegados( );
}
