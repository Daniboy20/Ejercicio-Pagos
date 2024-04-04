package unah.hn.lenguajes.demo.pagos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    @Column(name = "fechaingreso")
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "empleado")
    @JsonManagedReference
    private List<HistoricoPagos> historicopagos;

}
