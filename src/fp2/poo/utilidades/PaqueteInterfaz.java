/*
 *  @(#)PaqueteInterfaz.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */

package fp2.poo.utilidades;

import java.net.InetAddress;
import fp2.poo.utilidades.IstInterfaz;
import fp2.poo.utilidades.DatosInterfaz;

/**
 * Esta interfaz contiene los metodos asociados a un paquete.
 *
 *                             
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II
 */
public interface PaqueteInterfaz {

    /*
     *  Metodo de establecimiento del Ist destino 
     *  @param  direccionOrigen direccion origen.          
     */
    public void setIstDestino( IstInterfaz istDestino );

    /*
     *  Metodo de obtencion del ist destino.
     *  @return el Ist  destino	 
     */    
    public IstInterfaz getIstDestino( );
	
    /*
     *  Metodo de establecimiento del ist origen. 
     *  @param istOrigen es el ist origen           
     */
    public void setIstOrigen( IstInterfaz istOrigen );

    /*
     *  Metodo de obtencion del ist  origen.          
     *  @return   devuelve el ist de origen.	
     */
    public IstInterfaz getIstOrigen( );
	
    /**
     *  Metodo que proporciona un valor 
     *  para configurar el campo data.
     */ 
    public DatosInterfaz getDatos ( );

    /**
     * Metodo que devuelve los datos de un paquete 
	 * como String.
     */
    public void setDatos ( DatosInterfaz datos );
}
