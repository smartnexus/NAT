/*
 *  @(#)PuertoIncorrectoExcepcion.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */

package fp2.poo.utilidades.Excepciones;
        
/**
 * Esta excepcion se lanza cuando se intenta
 * crear un objeto Puerto con un valor incorrecto.
 *
 * El rango valido para un puerto es desde 1025 a 65535.
 * 
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II
 */
public class PuertoIncorrectoExcepcion extends Exception{

    /** 
      * Este atributo estatico se incluye para evitar el warning con la opcion -Xlint 
      * Es necesario ya que la clase Exception es serializable 
      * (este tema no se ve en practica).
      */
    private static final long serialVersionUID = -1L;
	
	/* Atributo usado que se usa para describir la excepcion.*/
    private String str = null;

	/*
	 * Constructor sin parametros
	 */
	public PuertoIncorrectoExcepcion() {}

	/*
	 * Constructor con un parametro de tipo String.
	 * @param el parametro proporciona una descripcion de la excepcion.
	 */	
    public PuertoIncorrectoExcepcion(String str) {
	    this.str = str;
    }  

	/*
	 * Constructor con un parametro de tipo int.
	 * @param el parametro proporciona el numero de puerto que provoca la excepcion.
	 */		
    public PuertoIncorrectoExcepcion(int puerto) {
        this.str = "El numero de puerto "+puerto+ " es incorrecto.";
    }  

	/*
	 * Sobrescritura del metodo toString de la clase Object
	 */
    public String toString() {
        return str;
    }
}
