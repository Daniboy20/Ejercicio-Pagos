package unah.hn.lenguajes.demo.pagos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.hn.lenguajes.demo.pagos.entities.Empleado;
import unah.hn.lenguajes.demo.pagos.repositories.EmpleadoRepository;
import unah.hn.lenguajes.demo.pagos.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public String eliminarEmpleado(String dni) {
        this.empleadoRepository.deleteById(dni);
        return "Empleado eliminado con exito";
    }

    @Override
    public Empleado buscarEmpleado(String dni) {
       return this.empleadoRepository.findById(dni).get();
    }

    @Override
    public List<Empleado> todosEmpleado() {
        return (List<Empleado>) this.empleadoRepository.findAll();
    }
    
}
