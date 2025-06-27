package pe.cibertec.proy_sistema_almacen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaCrearDto;
import pe.cibertec.proy_sistema_almacen.dto.CategoriaListarDto;
import pe.cibertec.proy_sistema_almacen.entity.Categoria;
import pe.cibertec.proy_sistema_almacen.repository.CategoriasRepository;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceCategoriasService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceCategoriasServiceImpl implements MaintenanceCategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<CategoriaListarDto> listarCategorias() throws Exception {
        List<CategoriaListarDto> categoriasDto = new ArrayList<>();
        categoriasRepository.findAll().forEach(cat -> {
            categoriasDto.add(new CategoriaListarDto(
                    cat.getIdCategoria(),
                    cat.getNombreCategoria(),
                    cat.getDescripcion(),
                    cat.getEstado()
            ));
        });
        return categoriasDto;
    }

    @Override
    public Optional<CategoriaListarDto> listarIdCategoria(int id) throws Exception {
        return categoriasRepository.findById(id).map(cat ->
                new CategoriaListarDto(cat.getIdCategoria(), cat.getNombreCategoria(), cat.getDescripcion(), cat.getEstado())
        );
    }

    @Override
    public boolean agregarCategoria(CategoriaCrearDto dto) throws Exception {
        Categoria cat = new Categoria(null, dto.nombreCategoria(), dto.descripcion(), dto.estado());
        categoriasRepository.save(cat);
        return true;
    }

    @Override
    public boolean actualizarCategoria(CategoriaCrearDto dto) throws Exception {
        Optional<Categoria> optional = categoriasRepository.findById(dto.idCategoria());
        return optional.map(cat -> {
            cat.setNombreCategoria(dto.nombreCategoria());
            cat.setDescripcion(dto.descripcion());
            cat.setEstado(dto.estado());
            categoriasRepository.save(cat);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean borrarCategoriaId(int id) throws Exception {
        Optional<Categoria> optional = categoriasRepository.findById(id);
        return optional.map(cat -> {
            categoriasRepository.delete(cat);
            return true;
        }).orElse(false);
    }
}