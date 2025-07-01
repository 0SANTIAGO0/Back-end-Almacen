package pe.cibertec.proy_sistema_almacen.soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.cibertec.proy_sistema_almacen.service.MaintenanceCategoriasService;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaCrearDto;


import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaCrearResponse;
import pe.cibertec.proy_sistema_almacen.ws.categoria.Categoria;
import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaCrearRequest;
import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaModificarRequest;
import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaModificarResponse;
import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaEliminarRequest;
import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaEliminarResponse;
import pe.cibertec.proy_sistema_almacen.ws.categoria.CategoriaListarResponse;

@Endpoint
public class CategoriaEndpoint {

    private static final String NAMESPACE_URI = "http://pe.cibertec/ws/categoria";

    @Autowired
    private MaintenanceCategoriasService categoriasService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CategoriaCrearRequest")
    @ResponsePayload
    public CategoriaCrearResponse crearCategoria(@RequestPayload CategoriaCrearRequest request) throws Exception {

        CategoriaCrearResponse response = new CategoriaCrearResponse();
        CategoriaCrearDto dto = new CategoriaCrearDto();
        Categoria categoriaXml = request.getCategoria();

        dto.setNombreCategoria(categoriaXml.getNombreCategoria());
        dto.setDescripcion(categoriaXml.getDescripcion());
        dto.setEstado(categoriaXml.getEstado());

        categoriasService.agregarCategoria(dto);

        response.setMensaje("Categoría creada correctamente");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CategoriaListarRequest")
    @ResponsePayload
    public CategoriaListarResponse listarCategorias() throws Exception {
        CategoriaListarResponse response = new CategoriaListarResponse();

        categoriasService.listarCategorias().forEach(catDto -> {
            Categoria categoriaWs = new Categoria();
            categoriaWs.setIdCategoria(catDto.getIdCategoria());
            categoriaWs.setNombreCategoria(catDto.getNombreCategoria());
            categoriaWs.setDescripcion(catDto.getDescripcion());
            categoriaWs.setEstado(catDto.getEstado());
            response.getCategoria().add(categoriaWs);
        });

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CategoriaModificarRequest")
    @ResponsePayload
    public CategoriaModificarResponse modificarCategoria(@RequestPayload CategoriaModificarRequest request) throws Exception {
        CategoriaModificarResponse response = new CategoriaModificarResponse();
        CategoriaCrearDto dto = new CategoriaCrearDto();

        Categoria categoriaXml = request.getCategoria();
        dto.setIdCategoria(categoriaXml.getIdCategoria());
        dto.setNombreCategoria(categoriaXml.getNombreCategoria());
        dto.setDescripcion(categoriaXml.getDescripcion());
        dto.setEstado(categoriaXml.getEstado());

        boolean actualizado = categoriasService.actualizarCategoria(dto);
        response.setMensaje(actualizado ? "Categoría actualizada correctamente" : "Categoría no encontrada");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CategoriaEliminarRequest")
    @ResponsePayload
    public CategoriaEliminarResponse eliminarCategoria(@RequestPayload CategoriaEliminarRequest request) throws Exception {
        CategoriaEliminarResponse response = new CategoriaEliminarResponse();

        boolean eliminado = categoriasService.borrarCategoriaId(request.getIdCategoria());
        response.setMensaje(eliminado ? "Categoría eliminada correctamente" : "Categoría no encontrada");

        return response;
    }
}
