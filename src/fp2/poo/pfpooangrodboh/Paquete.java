package fp2.poo.pfpooangrodboh;

import fp2.poo.utilidades.DatosInterfaz;
import fp2.poo.utilidades.IstInterfaz;
import fp2.poo.utilidades.PaqueteInterfaz;

public class Paquete implements PaqueteInterfaz {

    private IstInterfaz istDestino;
    private IstInterfaz istOrigen;
    private DatosInterfaz datos;

    public Paquete(IstInterfaz istOrigen, IstInterfaz istDestino, DatosInterfaz datos) {
        this.istOrigen = istOrigen;
        this.istDestino = istDestino;
        this.datos = datos;
    }

    @Override
    public void setIstDestino(IstInterfaz istDestino) {
        this.istDestino = istDestino;
    }

    @Override
    public IstInterfaz getIstDestino() {
        return istDestino;
    }

    @Override
    public void setIstOrigen(IstInterfaz istOrigen) {
        this.istOrigen = istOrigen;
    }

    @Override
    public IstInterfaz getIstOrigen() {
        return istOrigen;
    }

    /**
     * Metodo que proporciona un valor
     * para configurar el campo data.
     */
    @Override
    public DatosInterfaz getDatos() {
        return datos;
    }

    /**
     * Metodo que devuelve los datos de un paquete
     * como String.
     *
     * @param datos
     */
    @Override
    public void setDatos(DatosInterfaz datos) {
        this.datos = datos;
    }
}
