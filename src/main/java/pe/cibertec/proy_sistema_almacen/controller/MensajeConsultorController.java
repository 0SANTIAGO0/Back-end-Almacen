package pe.cibertec.proy_sistema_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.proy_sistema_almacen.dto.MensajeConsultorDto;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceMensajeConsultorService;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "http://localhost:5173")
public class MensajeConsultorController {

    @Autowired
    private MaintenanceMensajeConsultorService mensajeService;

    @GetMapping
    public List<MensajeConsultorDto> listarMensajes() {
        return mensajeService.listarMensajes();
    }

    @PostMapping
    public MensajeConsultorDto crearMensaje(@RequestBody MensajeConsultorDto dto) {
        return mensajeService.crearMensaje(dto);
    }

    @PutMapping("/{id}/estado")
    public MensajeConsultorDto cambiarEstado(
            @PathVariable Integer id,
            @RequestParam String estado
    ) {
        return mensajeService.cambiarEstado(id, estado);
    }

}
