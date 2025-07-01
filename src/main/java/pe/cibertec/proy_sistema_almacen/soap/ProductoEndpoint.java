//package pe.cibertec.proy_sistema_almacen.soap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import pe.cibertec.proy_sistema_almacen.service.MaintenanceProductoService;
//import pe.cibertec.proy_sistema_almacen.dto.ProductoCrearDto;
//import pe.cibertec.proy_sistema_almacen.ws.producto.Producto;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoCrearRequest;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoCrearResponse;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoModificarRequest;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoModificarResponse;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoEliminarRequest;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoEliminarResponse;
//import pe.cibertec.proy_sistema_almacen.ws.producto.ProductoListarResponse;
//
//@Endpoint
//public class ProductoEndpoint {
//
//    private static final String NAMESPACE_URI = "http://pe.cibertec/ws/producto";
//
//    @Autowired
//    private MaintenanceProductoService productosService;
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoCrearRequest")
//    @ResponsePayload
//    public ProductoCrearResponse crearProducto(@RequestPayload ProductoCrearRequest request) throws Exception {
//        ProductoCrearResponse response = new ProductoCrearResponse();
//        ProductoCrearDto dto = new ProductoCrearDto();
//
//        Producto productoXml = request.getProducto();
//        dto.setNombreProducto(productoXml.getNombreProducto());
//        dto.setDescripcion(productoXml.getDescripcion());
//        dto.setIdMarca(productoXml.getIdMarca());
//        dto.setIdCategoria(productoXml.getIdCategoria());
//        dto.setStockActual(productoXml.getStockActual());
//        dto.setStockMinimo(productoXml.getStockMinimo());
//        dto.setEstado(productoXml.getEstado());
//
//        productosService.agregarProducto(dto);
//        response.setMensaje("Producto creado correctamente");
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoListarRequest")
//    @ResponsePayload
//    public ProductoListarResponse listarProductos() throws Exception {
//        ProductoListarResponse response = new ProductoListarResponse();
//
//        productosService.listarProductos().forEach(prodDto -> {
//            Producto productoWs = new Producto();
//            productoWs.setIdProducto(prodDto.getIdProducto());
//            productoWs.setNombreProducto(prodDto.getNombreProducto());
//            productoWs.setDescripcion(prodDto.getDescripcion());
//            productoWs.setIdMarca(prodDto.getIdMarca());
//            productoWs.setIdCategoria(prodDto.getIdCategoria());
//            productoWs.setStockActual(prodDto.getStockActual());
//            productoWs.setStockMinimo(prodDto.getStockMinimo());
//            productoWs.setEstado(prodDto.getEstado());
//            response.getProducto().add(productoWs);
//        });
//
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoModificarRequest")
//    @ResponsePayload
//    public ProductoModificarResponse modificarProducto(@RequestPayload ProductoModificarRequest request) throws Exception {
//        ProductoModificarResponse response = new ProductoModificarResponse();
//        ProductoCrearDto dto = new ProductoCrearDto();
//
//        Producto productoXml = request.getProducto();
//        dto.setIdProducto(productoXml.getIdProducto());
//        dto.setNombreProducto(productoXml.getNombreProducto());
//        dto.setDescripcion(productoXml.getDescripcion());
//        dto.setIdMarca(productoXml.getIdMarca());
//        dto.setIdCategoria(productoXml.getIdCategoria());
//        dto.setStockActual(productoXml.getStockActual());
//        dto.setStockMinimo(productoXml.getStockMinimo());
//        dto.setEstado(productoXml.getEstado());
//
//        boolean actualizado = productosService.actualizarProducto(dto);
//        response.setMensaje(actualizado ? "Producto actualizado correctamente" : "Producto no encontrado");
//
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductoEliminarRequest")
//    @ResponsePayload
//    public ProductoEliminarResponse eliminarProducto(@RequestPayload ProductoEliminarRequest request) throws Exception {
//        ProductoEliminarResponse response = new ProductoEliminarResponse();
//
//        boolean eliminado = productosService.borrarProductoId(request.getIdProducto());
//        response.setMensaje(eliminado ? "Producto eliminado correctamente" : "Producto no encontrado");
//
//        return response;
//    }
//}
//
