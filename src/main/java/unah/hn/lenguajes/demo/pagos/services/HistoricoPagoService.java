package unah.hn.lenguajes.demo.pagos.services;

import unah.hn.lenguajes.demo.pagos.entities.HistoricoPagos;
import java.util.List;
import java.time.LocalDate;

public interface HistoricoPagoService {
    
    public HistoricoPagos crearHistoricoPago(HistoricoPagos historicoPagos);

    public List<HistoricoPagos> obtenerPagos(HistoricoPagos historicoPagos, LocalDate fechaInicio,LocalDate fechaFin);

}
