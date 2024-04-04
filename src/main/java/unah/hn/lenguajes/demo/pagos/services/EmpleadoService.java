package unah.hn.lenguajes.demo.pagos.services;

import unah.hn.lenguajes.demo.pagos.entities.Empleado;
import java.util.List;

public interface EmpleadoService {
    
    public Empleado crearEmpleado(Empleado empleado);

    public String eliminarEmpleado(String dni);

    public Empleado buscarEmpleado(String dni);

    public List<Empleado> todosEmpleado();
}
