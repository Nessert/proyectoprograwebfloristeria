package proyecto.Models;

import java.io.Serializable;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table
@Data
public class Arreglos implements Serializable {

    private static final long serialVersionUID = 30L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArreglos;
    private int precio;
    private String descripcion;
    private String imagen;
    private String titulo;
}
