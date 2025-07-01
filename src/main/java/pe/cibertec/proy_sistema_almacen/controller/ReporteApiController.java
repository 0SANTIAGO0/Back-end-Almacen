package pe.cibertec.proy_sistema_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.proy_sistema_almacen.dto.ProductoBajoStockDTO;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceProductoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/reportes")
public class ReporteApiController {

    @Autowired
    private MaintenanceProductoService productoService;

    public ReporteApiController(MaintenanceProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos-bajo-stock")
    public List<ProductoBajoStockDTO> getProductosBajoStock() {
        return productoService.obtenerProductosBajoStock();
    }

}
