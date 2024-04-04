package unah.hn.lenguajes.demo.pagos.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.hn.lenguajes.demo.pagos.entities.Empleado;
import unah.hn.lenguajes.demo.pagos.entities.HistoricoPagos;
import unah.hn.lenguajes.demo.pagos.repositories.EmpleadoRepository;
import unah.hn.lenguajes.demo.pagos.repositories.HistoricoPagosRepository;
import unah.hn.lenguajes.demo.pagos.services.HistoricoPagoService;


@Service
public class HistoricoPagoServiceImpl implements HistoricoPagoService{

    @Autowired
    HistoricoPagosRepository historicoPagosRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    

    @Override
    public HistoricoPagos crearHistoricoPago(HistoricoPagos historicoPagos) {

        String dni = historicoPagos.getEmpleado().getDni();

        if(this.empleadoRepository.existsById(dni))
        {
           Empleado empleado = this.empleadoRepository.findById(dni).get();
           historicoPagos.setEmpleado(empleado);

           System.out.println(historicoPagos.getHorasTrabajadas());
           System.out.println(historicoPagos.getPrecioPorHora());

           if((historicoPagos.getHorasTrabajadas() > 0) && (historicoPagos.getPrecioPorHora() >0))
           {
                

                LocalDate fechaActual = LocalDate.now();
                historicoPagos.setFechaPagos(fechaActual);
                historicoPagos.setTotalSueldo(historicoPagos.getPrecioPorHora() * historicoPagos.getHorasTrabajadas());

                return this.historicoPagosRepository.save(historicoPagos);
           }
        }
        
        return null;

    }

    @Override
    public List<HistoricoPagos> obtenerPagos(HistoricoPagos historicoPagos, LocalDate fechaInicio ,LocalDate fechaFin) {
       
        String dni = historicoPagos.getEmpleado().getDni();    
        if(this.empleadoRepository.existsById(dni))
        {
            Empleado empleado = this.empleadoRepository.findById(dni).get();
            List<HistoricoPagos> pagosEnRango =  new ArrayList<>();

            for (HistoricoPagos pagos : empleado.getHistoricopagos())
            {
                LocalDate fechaPagos = pagos.getFechaPagos();
                if(fechaPagos.isAfter(fechaInicio) && fechaPagos.isBefore(fechaFin) )
                {
                    pagosEnRango.add(pagos);
                }
            }
               return pagosEnRango;
        }
        return null;
    }
    
}
