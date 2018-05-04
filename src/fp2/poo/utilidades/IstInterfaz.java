/*
 *  @(#)IstInterfaz.java
 *
 *  Fundamentos de Programacion II. GITT.
 *  Departamento de Ingenieria Telematica
 *  Universidad de Sevilla
 *  
 */
 
package fp2.poo.utilidades;

import fp2.poo.utilidades.PuertoInterfaz;
import java.net.InetAddress;

/**
 *
 * Descripcion: La clase IstInterfaz contiene dos atributos de tipo
 * PuertoInterfaz e InetAddress.
 *
 * @version version 1.0 Abril 2014
 * @author  Fundamentos de Programacion II 
 */
public interface IstInterfaz {


    /**
      *  Metodo que establece la direccion.
     */ 
    public void setDireccion ( InetAddress direccion );

    /**
     * Metodo que devuelve como InetAddress la direccion
.
     */
    public InetAddress getDireccion ();

    /**
     *  Metodo que establece el puerto.
     */ 
    public void setPuerto( PuertoInterfaz puerto );

    /**
     * Metodo que devuelve como PuertoInterfaz  el puerto.
     */
    public PuertoInterfaz  getPuerto();

}
