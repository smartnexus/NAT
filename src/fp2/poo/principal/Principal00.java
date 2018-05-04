/*
 *  @(#)Principal00.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */

package fp2.poo.principal;

import fp2.poo.pfpooangrodboh.Nat;
import  fp2.poo.utilidades.Excepciones.OperacionNoPermitidaExcepcion;

import  fp2.poo.utilidades.LecturaFicheroEntrada;
import  fp2.poo.utilidades.PaqueteInterfaz;

/**
 * Descripcion: Esta clase contiene el metodo main.
 * Obtiene los valores proporcionados mediante los argumentos
 * en linea de comandos y se lo proporciona a las clases 
 * para realizar la traduccion de los paquetes.             
 *
 * En este ejemplo, la lectura del fichero se realiza dos veces y
 * de dos formas diferentes:
 *
 *
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II
 */
public class Principal00 {

    public static void main(String args[]) {
	
        LecturaFicheroEntrada lectura;
        Nat nat;
      
        try {  
            if (args.length != 2) {
                throw new OperacionNoPermitidaExcepcion("Numero de argumentos incorrecto.");
            } else {
                nat = new Nat(args[1]);  /* args[1] contiene la direccion externa del nat  */
                nat.traduce(args[0]);  /* args[0] contiene el fichero de paquetes  */
            }
            nat.eliminaRegistrosTraduccion();
	
	    lectura = new LecturaFicheroEntrada(args[0]);
            while(lectura.hasNext()){
        	    PaqueteInterfaz paquete = lectura.next();
                try {
                    nat.incrementaNumeroDePaquetesLlegados();
                    System.out.println("Paquete #" + nat.getNumeroDePaquetesLlegados());
                    System.out.println("==========");
                    System.out.println("Paquete Antes de traducirlo");
                    nat.muestraPaquete(paquete);
                    nat.traducePaquete(paquete);
                    System.out.println("Paquete despues de traducirlo");						
                    nat.muestraPaquete(paquete);
                    System.out.println("===================================");						
                } catch (OperacionNoPermitidaExcepcion e) {			
                    System.err.println("Este paquete no se puede traducir.");
                }				
            }			
            lectura.terminaLectura();
        } catch (OperacionNoPermitidaExcepcion e) {
            e.printStackTrace();
            System.err.println("Operacion no permitida.");
        }
    }
}


