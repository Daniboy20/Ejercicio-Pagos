package unah.hn.lenguajes.demo.pagos.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.hn.lenguajes.demo.pagos.entities.Empleado;
import unah.hn.lenguajes.demo.pagos.services.impl.EmpleadoServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoServiceImpl EmpleadoServiceImpl;


    @PostMapping("/crear")
    public Empleado crearEmpleado(@RequestBody Empleado empleado)
    {
        return this.EmpleadoServiceImpl.crearEmpleado(empleado);
    }

    @DeleteMapping("/eliminar")
    public String eliminarEmpleado(@RequestParam String dni)
    {
        return this.EmpleadoServiceImpl.eliminarEmpleado(dni);
    }

    @GetMapping("/buscar")
    public Empleado buscarEmpleado(@RequestParam String dni)
    {
        return this.EmpleadoServiceImpl.buscarEmpleado(dni);
    }

    @GetMapping("/todos")
    public List<Empleado> todosEmpleado()
    {
        return this.EmpleadoServiceImpl.todosEmpleado();
    }

}
