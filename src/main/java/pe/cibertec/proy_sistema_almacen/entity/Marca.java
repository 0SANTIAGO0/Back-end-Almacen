package pe.cibertec.proy_sistema_almacen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marcas") // Mapea a la tabla 'marcas' en la base de datos
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idMarca;

    @Column(name = "nombre_marca", nullable = false) // Coincide con la columna de BD
    private String nombreMarca; // Usamos camelCase en Java para 'nombre_marca'

    @Column(name = "pais_origen") // Coincide con la columna de BD
    private String paisOrigen; // Usamos camelCase en Java para 'pais_origen'

    @Column(name = "estado") // Campo 'estado' como String
    private String estado;
}