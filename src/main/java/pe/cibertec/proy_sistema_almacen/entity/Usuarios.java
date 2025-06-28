package pe.cibertec.proy_sistema_almacen.entity;

import jakarta.persistence.Column; // Importar Column
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Importar Table
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios") // Asegura el mapeo a la tabla 'usuarios'
public class Usuarios { // Mantengo el nombre de tu clase como 'Usuarios'

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario") // Mapea a la columna 'id_usuario'
    private Integer idUsuario;

    @Column(name = "nombre_usuario", nullable = false) // Mapea a la columna 'nombre_usuario'
    private String nombreUsuario;

    @Column(name = "correo", unique = true, nullable = false) // Mapea a la columna 'correo'
    private String correo;

    @Column(name = "contrasenia", nullable = false) // ¡CORRECCIÓN CLAVE AQUÍ! Mapea a 'contraseña' con 'ñ'
    private String contrasenia; // El nombre del campo en Java sigue siendo 'contrasenia'

    @Column(name = "rol", nullable = false) // Mapea a la columna 'rol'
    private String rol;

    @Column(name = "estado", nullable = false) // Mapea a la columna 'estado'
    private Boolean estado;

}
