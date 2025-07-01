package pe.cibertec.proy_sistema_almacen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.dto.MensajeConsultorDto;
import pe.cibertec.proy_sistema_almacen.entity.MensajeConsultor;
import pe.cibertec.proy_sistema_almacen.repository.MensajeConsultorRepository;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceMensajeConsultorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceMensajeConsultorServiceImpl implements MaintenanceMensajeConsultorService {

    @Autowired
    private MensajeConsultorRepository mensajeRepo;


    @Override
    public List<MensajeConsultorDto> listarMensajes() {
        return mensajeRepo.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MensajeConsultorDto crearMensaje(MensajeConsultorDto mensajeDto) {
        MensajeConsultor mensaje = new MensajeConsultor();
        mensaje.setNombreProducto(mensajeDto.nombreProducto());
        mensaje.setMensaje(mensajeDto.mensaje());
        mensaje.setCantidad(mensajeDto.cantidad());
        mensaje.setEstado("PENDIENTE");
        mensaje = mensajeRepo.save(mensaje);
        return toDto(mensaje);
    }

    @Override
    public MensajeConsultorDto cambiarEstado(Integer id, String nuevoEstado) {
        MensajeConsultor mensaje = mensajeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensaje no encontrado"));
        mensaje.setEstado(nuevoEstado);
        mensaje = mensajeRepo.save(mensaje);
        return toDto(mensaje);
    }


    private MensajeConsultorDto toDto(MensajeConsultor entity) {
        return new MensajeConsultorDto(
                entity.getId(),
                entity.getNombreProducto(),
                entity.getMensaje(),
                entity.getCantidad(),
                entity.getEstado()
        );
    }
}
