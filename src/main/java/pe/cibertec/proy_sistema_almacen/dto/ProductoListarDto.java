package pe.cibertec.proy_sistema_almacen.dto;

public record ProductoListarDto(
        Integer idProducto,
        String nombreProducto,
        String descripcion,
        String nombreMarca,
        String nombreCategoria,
        Integer stockActual,
        Integer stockMinimo,
        String estado
) {}
