package pe.cibertec.proy_sistema_almacen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoSoapDto {
    private Integer idProducto;
    private String nombreProducto;
    private String descripcion;
    private Integer idMarca;
    private Integer idCategoria;
    private Integer stockActual;
    private Integer stockMinimo;
    private String estado;
}
