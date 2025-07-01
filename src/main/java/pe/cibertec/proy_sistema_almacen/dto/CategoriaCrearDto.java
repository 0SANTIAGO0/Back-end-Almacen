package pe.cibertec.proy_sistema_almacen.dto;
/*
public record CategoriaCrearDto(
        Integer idCategoria,
        String nombreCategoria,
        String descripcion,
        String estado) {

}*/

/*codigo para xml*/
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaCrearDto {
    private Integer idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String estado;
}
