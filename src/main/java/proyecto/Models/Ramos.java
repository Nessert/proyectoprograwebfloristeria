package proyecto.Models;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Ramos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRamos;
    private int precio;
    private String descripcion;
    private String imagen;
    private String titulo;
}