package pe.cibertec.proy_sistema_almacen.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.proy_sistema_almacen.dto.ProductoBajoStockDTO;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceProductoService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    @GetMapping("/productos-bajo-stock/excel")
    public ResponseEntity<byte[]> descargarExcel() throws IOException {
        List<ProductoBajoStockDTO> productos = productoService.obtenerProductosBajoStock();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Productos Bajo Stock");

        // Cabecera
        Row headerRow = sheet.createRow(0);
        String[] headers = { "ID", "Producto", "Categoría", "Marca", "Stock Actual", "Stock Mínimo" };
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Datos
        int rowNum = 1;
        for (ProductoBajoStockDTO p : productos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getIdProducto());
            row.createCell(1).setCellValue(p.getNombreProducto());
            row.createCell(2).setCellValue(p.getNombreCategoria());
            row.createCell(3).setCellValue(p.getNombreMarca());
            row.createCell(4).setCellValue(p.getStockActual());
            row.createCell(5).setCellValue(p.getStockMinimo());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        byte[] excelBytes = out.toByteArray();

        HttpHeaders headersExcel = new HttpHeaders();
        headersExcel.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headersExcel.setContentDisposition(ContentDisposition.attachment().filename("reporte_bajo_stock.xlsx").build());

        return new ResponseEntity<>(excelBytes, headersExcel, HttpStatus.OK);
    }
}
