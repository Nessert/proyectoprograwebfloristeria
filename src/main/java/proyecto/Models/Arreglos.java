package proyecto.Models;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table
@Data
public class Arreglos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArreglos;
    private int precio;
    private String descripcion;
    private String imagen;
    private String titulo;
}
