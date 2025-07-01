package pe.cibertec.proy_sistema_almacen.repository;

import org.springframework.data.repository.CrudRepository;
import pe.cibertec.proy_sistema_almacen.entity.Categoria;

import java.util.List;

public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {

    //List<Categoria> findByEstado(int estado);
}

