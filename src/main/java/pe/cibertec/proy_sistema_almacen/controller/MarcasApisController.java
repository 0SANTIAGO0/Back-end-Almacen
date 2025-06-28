package pe.cibertec.proy_sistema_almacen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.proy_sistema_almacen.entity.Marca;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceMarcaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcasApisController {

    @Autowired
    private MaintenanceMarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarcas() throws Exception {
        List<Marca> marcas = marcaService.listarMarcas();
        if (marcas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marcas);
    }
}
