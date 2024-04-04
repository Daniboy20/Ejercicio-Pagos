package unah.hn.lenguajes.demo.pagos.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.hn.lenguajes.demo.pagos.entities.HistoricoPagos;
import unah.hn.lenguajes.demo.pagos.services.impl.HistoricoPagoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.time.LocalDate;


@RestController
@RequestMapping("/api/historicopagos")
public class HistoricoPagosController {
 
    @Autowired
    private HistoricoPagoServiceImpl historicoPagoServiceImpl;

    @PostMapping("/crear")    
    public HistoricoPagos crearHistoricoPagos(@RequestBody HistoricoPagos historicoPagos)
    {
        return this.historicoPagoServiceImpl.crearHistoricoPago(historicoPagos);
    }

    @GetMapping("/pagos")
    public List<HistoricoPagos> obtenerPagos(@RequestBody HistoricoPagos historicoPagos, @RequestParam LocalDate fechaInicio ,@RequestParam LocalDate fechaFin) {
        return this.historicoPagoServiceImpl.obtenerPagos(historicoPagos, fechaInicio, fechaFin);
    }
    


}
