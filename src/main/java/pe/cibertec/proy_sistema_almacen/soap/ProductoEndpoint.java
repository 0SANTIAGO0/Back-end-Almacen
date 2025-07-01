package pe.cibertec.proy_sistema_almacen.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.cibertec.proy_sistema_almacen.service.MaintenanceProductoService;
import pe.cibertec.proy_sistema_almacen.dto.ProductoCrearDto;
import pe.cibertec.proy_sistema_almacen.ws.producto.*;

@Endpoint
public class ProductoEndpoint {

    private static final String NAMESPACE_URI = "http://pe.cibertec/ws/producto";

    @Autowired
    private MaintenanceProductoService productosService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoCrearRequest")
    @ResponsePayload
    public ProductoCrearResponse crearProducto(@RequestPayload ProductoCrearRequest request) throws Exception {
        ProductoCrearResponse response = new ProductoCrearResponse();

        Producto p = request.getProducto();

        ProductoCrearDto dto = new ProductoCrearDto(
                null, // el id se autogenera
                p.getNombreProducto(),
                p.getDescripcion(),
                p.getIdMarca(),
                p.getIdCategoria(),
                p.getStockActual(),
                p.getStockMinimo(),
                p.getEstado()
        );

        productosService.agregarProducto(dto);
        response.setMensaje("Producto creado correctamente");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoListarRequest")
    @ResponsePayload
    public ProductoListarResponse listarProductos() throws Exception {
        ProductoListarResponse response = new ProductoListarResponse();

        productosService.listarProductos().forEach(dto -> {
            Producto prodWs = new Producto();
            prodWs.setIdProducto(dto.idProducto());
            prodWs.setNombreProducto(dto.nombreProducto());
            prodWs.setDescripcion(dto.descripcion());
            prodWs.setIdMarca(dto.idMarca());
            prodWs.setIdCategoria(dto.idCategoria());
            prodWs.setStockActual(dto.stockActual());
            prodWs.setStockMinimo(dto.stockMinimo());
            prodWs.setEstado(dto.estado());
            prodWs.setNombreMarca(dto.nombreMarca());
            prodWs.setNombreCategoria(dto.nombreCategoria());
            response.getProducto().add(prodWs);
        });

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoModificarRequest")
    @ResponsePayload
    public ProductoModificarResponse modificarProducto(@RequestPayload ProductoModificarRequest request) throws Exception {
        ProductoModificarResponse response = new ProductoModificarResponse();

        Producto p = request.getProducto();

        ProductoCrearDto dto = new ProductoCrearDto(
                p.getIdProducto(),
                p.getNombreProducto(),
                p.getDescripcion(),
                p.getIdMarca(),
                p.getIdCategoria(),
                p.getStockActual(),
                p.getStockMinimo(),
                p.getEstado()
        );

        boolean actualizado = productosService.actualizarProducto(dto);
        response.setMensaje(actualizado ? "Producto actualizado correctamente" : "Producto no encontrado");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoEliminarRequest")
    @ResponsePayload
    public ProductoEliminarResponse eliminarProducto(@RequestPayload ProductoEliminarRequest request) throws Exception {
        ProductoEliminarResponse response = new ProductoEliminarResponse();

        boolean eliminado = productosService.borrarProductoId(request.getIdProducto());
        response.setMensaje(eliminado ? "Producto eliminado correctamente" : "Producto no encontrado");

        return response;
    }
}
