/*
 *  @(#)DatosInterfaz.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */
 
package fp2.poo.utilidades;

/**
 *
 * La interfaz DatosInterfaz mantiene los metodos 
 * para manejar el campo de datos de un paquete.
 *
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II 
 */
public interface DatosInterfaz {
	
    /**
     *  Metodo que proporciona un valor 
     *  para configurar el campo datos.
     */ 
    public String getDatos (  );

    /**
     * Metodo que devuelve los datos de un paquete 
	 * como String.
     */
    public void setDatos ( String datos );

}
