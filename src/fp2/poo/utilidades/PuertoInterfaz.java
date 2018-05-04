/*
 *  @(#)PuertoInterfaz.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */
 
package fp2.poo.utilidades;

import fp2.poo.utilidades.Excepciones.PuertoIncorrectoExcepcion;

/**
 *
 * Descripcion: La clase Puerto contiene un atributo int de nombre puerto.
 *
 * El constructor de esta clase debe comprobar que el objeto de tipo int 
 * proporcionado tenga un valor comprendido entre 1025 y 65535. 
 * En caso contrario se debe lanzar la excepcion PuertoIncorrectoExcepcion.
 *
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II 
 */
public interface PuertoInterfaz {

    /**
     *  Metodo que proporciona un valor 
     *  para establecer el numero del puerto.
     */ 
    public void setPuerto( int puerto ) throws PuertoIncorrectoExcepcion;

    /**
     * Metodo que devuelve como int el numero del puerto.
     */
    public int getPuerto();

}
