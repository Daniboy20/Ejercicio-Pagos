package unah.hn.lenguajes.demo.pagos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@Table(name = "historicopagos")
@Data
public class HistoricoPagos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fechapagos")
    private LocalDate fechaPagos;

    @Column(name = "horastrabajadas")
    private long horasTrabajadas;

    @Column(name = "precioporhora")
    private double precioPorHora;

    @Column(name = "totalsueldo")
    private double totalSueldo;

    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @JsonBackReference
    private Empleado empleado;

}
