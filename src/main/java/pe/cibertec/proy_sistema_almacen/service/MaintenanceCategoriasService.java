package pe.cibertec.proy_sistema_almacen.service;

import pe.cibertec.proy_sistema_almacen.dto.CategoriaCrearDto;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaListarDto;
import pe.cibertec.proy_sistema_almacen.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface MaintenanceCategoriasService {

    //List<CategoriaListarDto> listarCategorias() throws Exception;
    //Optional<CategoriaListarDto> listarIdCategoria(int id) throws Exception;
    //boolean agregarCategoria(CategoriaCrearDto dto) throws Exception;
    //boolean actualizarCategoria(CategoriaCrearDto dto) throws Exception;
    //boolean borrarCategoriaId(int id) throws Exception;

    List<Categoria> listarCategorias() throws Exception;
    Optional<Categoria> listarCategoriaId(int id) throws Exception;
    boolean agregarCategoria(Categoria categoria) throws Exception;
    boolean actualizarCategoria(Categoria categoria) throws Exception;
    boolean borrarCategoriaId(int id) throws Exception;

}