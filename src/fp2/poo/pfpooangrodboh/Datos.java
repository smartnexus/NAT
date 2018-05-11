package fp2.poo.pfpooangrodboh;

import fp2.poo.utilidades.DatosInterfaz;

public class Datos implements DatosInterfaz {
    /**
     * Metodo que proporciona un valor
     * para configurar el campo datos.
     */

    private String datos;

    public Datos(String datos) {
        this.datos = datos;
    }

    @Override
    public String getDatos() {
        return datos;
    }

    /**
     * Metodo que devuelve los datos de un paquete
     * como String.
     *
     * @param datos
     */
    @Override
    public void setDatos(String datos) {
        this.datos = datos;
    }

    /**
     * Metodo que devuelve los datos en un objeto String.
     */
    @Override
    public String toString() {
        return datos;
    }
}
