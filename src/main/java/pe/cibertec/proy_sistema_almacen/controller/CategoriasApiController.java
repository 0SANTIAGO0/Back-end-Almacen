package pe.cibertec.proy_sistema_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaCrearDto;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaListarDto;
import pe.cibertec.proy_sistema_almacen.entity.Categoria;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceCategoriasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriasApiController {

    @Autowired
    private MaintenanceCategoriasService service;

    /*@GetMapping
    public ResponseEntity<List<CategoriaListarDto>> listar() throws Exception {
        return ResponseEntity.ok(service.listarCategorias());
    }*/
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() throws Exception {
        List<Categoria> categorias = service.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listarPorId(@PathVariable int id) throws Exception {
        return service.listarCategoriaId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody Categoria dto) throws Exception {
        service.agregarCategoria(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody CategoriaCrearDto dto) throws Exception {
        Categoria actualizado = new Categoria(id, dto.nombreCategoria(), dto.descripcion(), dto.estado());
        boolean actualizadoOk = service.actualizarCategoria(actualizado);
        return actualizadoOk ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id) throws Exception {
        service.borrarCategoriaId(id);
        return ResponseEntity.noContent().build();
    }
}
