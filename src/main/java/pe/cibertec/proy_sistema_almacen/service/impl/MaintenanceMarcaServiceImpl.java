package pe.cibertec.proy_sistema_almacen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.entity.Marca;
import pe.cibertec.proy_sistema_almacen.repository.MarcaRepository;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceMarcaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceMarcaServiceImpl implements MaintenanceMarcaService {


    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> listarMarcas(){
        List<Marca> marcas = new ArrayList<>();
        marcaRepository.findAll().forEach(m -> marcas.add(new Marca(
                m.getIdMarca(),
                m.getNombreMarca(),
                m.getPaisOrigen(),
                m.getEstado()
        )));
        return marcas;
    }

    @Override
    public Optional<Marca> listarMarcaId(int id) {
        return marcaRepository.findById(id).map(m-> new Marca(
                m.getIdMarca(),
                m.getNombreMarca(),
                m.getPaisOrigen(),
                m.getEstado()
        ));
    }

    @Override
    public boolean agregarMarca(Marca marca){
        Marca m = new Marca(
                marca.getIdMarca(),
                marca.getNombreMarca(),
                marca.getPaisOrigen(),
                marca.getEstado()
        );
        marcaRepository.save(m);
        return true;
    }



    @Override
    public boolean actualizarMarca(Marca marca) throws Exception {
        if (!marcaRepository.existsById(marca.getIdMarca())) {
            throw new Exception("Marca no encontrada");
        }
        Marca m = new Marca(
                marca.getIdMarca(),
                marca.getNombreMarca(),
                marca.getPaisOrigen(),
                marca.getEstado()
        );
        marcaRepository.save(m);
        return true;
    }

    @Override
    public boolean borrarMarcaId(int id) throws Exception {
        if (!marcaRepository.existsById(id)) {
            throw new Exception("Marca no encontrada");
        }
        marcaRepository.deleteById(id);
        return true;
    }
}
