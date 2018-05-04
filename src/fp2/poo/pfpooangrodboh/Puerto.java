package fp2.poo.pfpooangrodboh;

import fp2.poo.utilidades.Excepciones.PuertoIncorrectoExcepcion;
import fp2.poo.utilidades.PuertoInterfaz;


public class Puerto implements PuertoInterfaz {
    /**
     * Metodo que proporciona un valor
     * para establecer el numero del puerto.
     *
     * @param puerto
     */

    private int puerto;

    public Puerto(int puerto) throws PuertoIncorrectoExcepcion {
        if(puerto >= 1025 && puerto <= 65535) {
            this.puerto = puerto;
        } else {
            throw new PuertoIncorrectoExcepcion(puerto);
        }
    }

    @Override
    public void setPuerto(int puerto) throws PuertoIncorrectoExcepcion {
        if(puerto >= 1025 && puerto <= 65535) {
            this.puerto = puerto;
        } else {
            throw new PuertoIncorrectoExcepcion(puerto);
        }
    }

    /**
     * Metodo que devuelve como int el numero del puerto.
     */
    @Override
    public int getPuerto() {
        return puerto;
    }
}
