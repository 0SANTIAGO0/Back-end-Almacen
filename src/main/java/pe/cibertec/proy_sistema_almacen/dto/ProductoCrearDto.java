package pe.cibertec.proy_sistema_almacen.dto;

public record ProductoCrearDto(
        Integer idProducto,
        String nombreProducto,
        String descripcion,
        Integer idMarca,
        Integer idCategoria,
        Integer stockActual,
        Integer stockMinimo,
        String estado
) {}