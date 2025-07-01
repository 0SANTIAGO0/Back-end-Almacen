package pe.cibertec.proy_sistema_almacen.dto;

public record MensajeConsultorDto( Integer id,
                                 String nombreProducto,
                                 String mensaje,
                                 Integer cantidad,
                                 String estado) {
}
