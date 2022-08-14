package proyecto.Models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table
@Data
public class fechasEspeciales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idfechasEspeciales;
    private int precio;
    private String descripcion;
    private String imagen;
    private String titulo;
}