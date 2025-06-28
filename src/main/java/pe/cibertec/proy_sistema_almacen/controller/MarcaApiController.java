package pe.cibertec.proy_sistema_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.proy_sistema_almacen.dto.MarcaRequestDto;
import pe.cibertec.proy_sistema_almacen.dto.MarcaResponseDto;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceMarcaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marcas") // Prefijo de URL para todas las rutas de marcas
@CrossOrigin(origins = "http://localhost:5173") // Asegura que CORS esté configurado para tu frontend
public class MarcaApiController {

    @Autowired
    private MaintenanceMarcaService marcaService;

    // GET: /api/marcas - Listar todas las marcas (ahora devuelve MarcaResponseDto)
    @GetMapping
    public ResponseEntity<List<MarcaResponseDto>> listarMarcas() {
        List<MarcaResponseDto> marcas = marcaService.listarMarcas();
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }

    // GET: /api/marcas/{id} - Obtener una marca por ID (ahora devuelve MarcaResponseDto)
    @GetMapping("/{id}")
    public ResponseEntity<MarcaResponseDto> buscarMarcaPorId(@PathVariable Integer id) {
        Optional<MarcaResponseDto> marca = marcaService.buscarMarcaPorId(id);
        return marca.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST: /api/marcas - Crear una nueva marca (ahora recibe MarcaRequestDto)
    @PostMapping
    public ResponseEntity<MarcaResponseDto> guardarMarca(@RequestBody MarcaRequestDto marcaDto) {
        // El servicio se encarga de las validaciones de negocio y de asignar el ID
        MarcaResponseDto nuevaMarca = marcaService.guardarMarca(marcaDto);
        return new ResponseEntity<>(nuevaMarca, HttpStatus.CREATED);
    }

    // PUT: /api/marcas/{id} - Actualizar una marca existente (ahora recibe MarcaRequestDto)
    @PutMapping("/{id}")
    public ResponseEntity<MarcaResponseDto> actualizarMarca(@PathVariable Integer id, @RequestBody MarcaRequestDto marcaDto) {
        try {
            MarcaResponseDto marcaActualizada = marcaService.actualizarMarca(id, marcaDto);
            return new ResponseEntity<>(marcaActualizada, HttpStatus.OK);
        } catch (RuntimeException e) { // Capturar la excepción lanzada por el servicio si la marca no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: /api/marcas/{id} - Eliminar una marca (borrado lógico, no se devuelve DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Integer id) {
        marcaService.eliminarMarca(id); // Llama al servicio que cambia el estado
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content para indicar exito
    }
}
