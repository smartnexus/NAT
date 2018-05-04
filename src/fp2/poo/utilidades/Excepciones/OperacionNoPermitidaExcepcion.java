/*
 *  @(#)OperacionNoPermitidaExcepcion.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */

package fp2.poo.utilidades.Excepciones;

/**
 * Esta excepcion se lanza cuando se intenta
 * realizar una operacion incorrecta.
 *
 * En el caso del Iterador para obtener los
 * objetos del tipo Paquete, si se intenta obtener
 * un objeto que no existe.
 *                             
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II
 */
public class OperacionNoPermitidaExcepcion extends Exception {

    /** 
      * Este atributo estatico se incluye para evitar el warning con la opcion -Xlint 
      * Es necesario ya que la clase Exception es serializable 
      * (este tema no se ve en practica).
      */
    private static final long serialVersionUID = -1L;
	
	/** Atributo usado que se usa para describir la excepcion.*/
    private String s;

	/*
	 * Constructor sin parametros
	 */
    public OperacionNoPermitidaExcepcion() {}
	
	/*
	 * Constructor con un parametro.
	 * @param el parametro proporciona una descripcion de la excepcion.
	 */
    public OperacionNoPermitidaExcepcion(String s){
        this.s = s;
    }

	/*
	 * Sobrescritura del metodo toString de la clase Object
	 */
    public String toString(){
	    return "" + this.s;
    }
}
