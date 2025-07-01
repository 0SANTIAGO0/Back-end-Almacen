package pe.cibertec.proy_sistema_almacen.dto;

/*public record CategoriaListarDto(
                        Integer idCategoria,
                        String nombreCategoria,
                        String descripcion,
                        String estado) {
*/

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaListarDto {
    private Integer idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String estado;

}

