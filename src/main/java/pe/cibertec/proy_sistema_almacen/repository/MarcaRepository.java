package pe.cibertec.proy_sistema_almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.proy_sistema_almacen.entity.Marca;

import java.util.List; // Se mantiene la importacion si es necesaria para otros metodos, pero findByEstado se elimina.

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    List<Marca> findByEstado(String activo);
    // Se elimina el metodo 'List<Marca> findByEstado(String estado);'
}