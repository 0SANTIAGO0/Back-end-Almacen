package pe.cibertec.proy_sistema_almacen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marcas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;

    @Column(name = "nombre_marca", nullable = false, unique = true)
    private String nombreMarca;

    @Column(name = "pais_origen")
    private String paisOrigen;

    @Column(name = "estado")
    private String estado = "Activo";
}
