package pe.cibertec.proy_sistema_almacen.service;

import pe.cibertec.proy_sistema_almacen.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MaintenanceMarcaService {

    List<Marca> listarMarcas() throws Exception;
    Optional<Marca> listarMarcaId(int id) throws Exception;
    boolean agregarMarca(Marca marca) throws Exception;
    boolean actualizarMarca(Marca marca) throws Exception;
    boolean borrarMarcaId(int id) throws Exception;
}
