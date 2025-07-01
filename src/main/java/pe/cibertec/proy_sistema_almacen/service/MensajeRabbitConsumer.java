package pe.cibertec.proy_sistema_almacen.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.config.RabbitMQConfig;
import pe.cibertec.proy_sistema_almacen.dto.MensajeConsultorDto;
import pe.cibertec.proy_sistema_almacen.entity.MensajeConsultor;
import pe.cibertec.proy_sistema_almacen.repository.MensajeConsultorRepository;

@Service
public class MensajeRabbitConsumer {

    private final MensajeConsultorRepository mensajeRepo;

    public MensajeRabbitConsumer(MensajeConsultorRepository mensajeRepo) {
        this.mensajeRepo = mensajeRepo;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void recibirMensaje(MensajeConsultorDto dto) {
        MensajeConsultor mensaje = new MensajeConsultor();
        mensaje.setNombreProducto(dto.nombreProducto());
        mensaje.setMensaje(dto.mensaje());
        mensaje.setCantidad(dto.cantidad());
        mensaje.setEstado("PENDIENTE");
        mensajeRepo.save(mensaje);

        System.out.println("Mensaje recibido desde RabbitMQ y guardado en mensajes_consultor");
    }
}