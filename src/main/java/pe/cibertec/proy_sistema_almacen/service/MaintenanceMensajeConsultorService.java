package pe.cibertec.proy_sistema_almacen.service;

import pe.cibertec.proy_sistema_almacen.dto.MensajeConsultorDto;

import java.util.List;

public interface MaintenanceMensajeConsultorService {

    List<MensajeConsultorDto> listarMensajes();
    MensajeConsultorDto crearMensaje(MensajeConsultorDto mensajeDto);
    MensajeConsultorDto cambiarEstado(Integer id, String nuevoEstado);

}
