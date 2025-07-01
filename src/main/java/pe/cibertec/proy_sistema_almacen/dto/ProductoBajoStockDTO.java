package pe.cibertec.proy_sistema_almacen.dto;

public record ProductoBajoStockDTO( Integer idProducto,
                                    String nombreProducto,
                                    String nombreCategoria,
                                    String nombreMarca,
                                    Integer stockActual,
                                    Integer stockMinimo) {
}
