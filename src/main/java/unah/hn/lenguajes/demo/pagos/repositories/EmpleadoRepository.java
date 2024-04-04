package unah.hn.lenguajes.demo.pagos.repositories;

import org.springframework.data.repository.CrudRepository;

import unah.hn.lenguajes.demo.pagos.entities.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, String>{
    
}
