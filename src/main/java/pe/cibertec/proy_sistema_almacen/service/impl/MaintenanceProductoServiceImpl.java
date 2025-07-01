package pe.cibertec.proy_sistema_almacen.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.dto.ProductoBajoStockDTO;
import pe.cibertec.proy_sistema_almacen.dto.ProductoCrearDto;
import pe.cibertec.proy_sistema_almacen.dto.ProductoListarDto;
import pe.cibertec.proy_sistema_almacen.entity.Categoria;
import pe.cibertec.proy_sistema_almacen.entity.Marca;
import pe.cibertec.proy_sistema_almacen.entity.Producto;
import pe.cibertec.proy_sistema_almacen.repository.CategoriasRepository;
import pe.cibertec.proy_sistema_almacen.repository.MarcaRepository;
import pe.cibertec.proy_sistema_almacen.repository.ProductoRepository;
import pe.cibertec.proy_sistema_almacen.service.MaintenanceProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceProductoServiceImpl implements MaintenanceProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriasRepository categoriaRepository;

    @Override
    public List<ProductoListarDto> listarProductos() {
        List<ProductoListarDto> dtos = new ArrayList<>();
        productoRepository.findAll().forEach(p -> dtos.add(new ProductoListarDto(
                p.getIdProducto(),
                p.getNombreProducto(),
                p.getDescripcion(),
                p.getMarca().getNombreMarca(),
                p.getCategoria().getNombreCategoria(),
                p.getStockActual(),
                p.getStockMinimo(),
                p.getEstado(),
                p.getMarca().getIdMarca(),
                p.getCategoria().getIdCategoria()
        )));
        return dtos;
    }

    @Override
    public Optional<ProductoListarDto> listarProductoId(int id) {
        return productoRepository.findById(id).map(p -> new ProductoListarDto(
                p.getIdProducto(),
                p.getNombreProducto(),
                p.getDescripcion(),
                p.getMarca().getNombreMarca(),
                p.getCategoria().getNombreCategoria(),
                p.getStockActual(),
                p.getStockMinimo(),
                p.getEstado(),
                p.getMarca().getIdMarca(),
                p.getCategoria().getIdCategoria()
        ));
    }

    @Override
    public boolean agregarProducto(ProductoCrearDto dto) throws Exception {
        // 1. Mapear DTO → entidad
        Producto p = new Producto();
        p.setNombreProducto(dto.nombreProducto());
        p.setDescripcion   (dto.descripcion());
        p.setStockActual   (dto.stockActual());
        p.setStockMinimo   (dto.stockMinimo());
        p.setEstado        (dto.estado());

        // 2. Cargar y asignar la categoría
        Categoria cat =categoriaRepository.findById(dto.idCategoria())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe categoría con id=" + dto.idCategoria()));
        p.setCategoria(cat);

        // 3. Cargar y asignar la marca
        Marca mar = marcaRepository.findById(dto.idMarca())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe marca con id=" + dto.idMarca()));
        p.setMarca(mar);

        // 4. Guardar
        productoRepository.save(p);
        return true; // Retorna true si se guardó correctamente}
    }

    @Override
    public boolean actualizarProducto(ProductoCrearDto producto) throws Exception {
        // 1. Buscar el producto existente
        Producto p = productoRepository.findById(producto.idProducto())
                .orElseThrow(() -> new EntityNotFoundException("Producto " + producto.idProducto() + " no existe"));

        // 2. Actualizar campos
        p.setNombreProducto(producto.nombreProducto());
        p.setDescripcion(producto.descripcion());
        p.setStockActual(producto.stockActual());
        p.setStockMinimo(producto.stockMinimo());
        p.setEstado(producto.estado());

        // 3. Cargar y asignar la categoría
        Categoria cat = categoriaRepository.findById(producto.idCategoria())
                .orElseThrow(() -> new IllegalArgumentException("No existe categoría con id=" + producto.idCategoria()));
        p.setCategoria(cat);

        // 4. Cargar y asignar la marca
        Marca mar = marcaRepository.findById(producto.idMarca())
                .orElseThrow(() -> new IllegalArgumentException("No existe marca con id=" + producto.idMarca()));
        p.setMarca(mar);

        // 5. Guardar
        productoRepository.save(p);
        return true; // Retorna true si se actualizó correctamente
    }

    @Override
    public boolean borrarProductoId(int id) {
        Optional<Producto> optional = productoRepository.findById(id);
        return optional.map(p -> {
            productoRepository.delete(p);
            return true;
        }).orElse(false);
    }

    @Override
    public List<ProductoBajoStockDTO> obtenerProductosBajoStock() {
        return productoRepository.findProductosBajoStock();
    }

    /*@Override
    public List<ProductoListarDto> listarProductos() {
        List<ProductoListarDto> dtos = new ArrayList<>();
        productoRepository.findAll().forEach(p -> dtos.add(new ProductoListarDto(
                p.getIdProducto(), p.getNombreProducto(), p.getDescripcion(),
                p.getStockActual(), p.getStockMinimo(), p.getEstado(), p.getCodigoPedido()
        )));
        return dtos;
    }

    @Override
    public Optional<ProductoListarDto> listarProductoId(int id) {
        return productoRepository.findById(id).map(p -> new ProductoListarDto(
                p.getIdProducto(), p.getNombreProducto(), p.getDescripcion(),
                p.getStockActual(), p.getStockMinimo(), p.getEstado(), p.getCodigoPedido()
        ));
    }

    @Override
    public boolean agregarProducto(ProductoCrearDto dto) {
        Producto p = new Producto(null, dto.nombreProducto(), dto.descripcion(),
                dto.stockActual(), dto.stockMinimo(), dto.estado(), null);
        productoRepository.save(p);
        return true;
    }

    @Override
    public boolean actualizarProducto(ProductoCrearDto dto) {
        Optional<Producto> optional = productoRepository.findById(dto.idProducto());
        return optional.map(p -> {
            p.setNombreProducto(dto.nombreProducto());
            p.setDescripcion(dto.descripcion());
            p.setStockActual(dto.stockActual());
            p.setStockMinimo(dto.stockMinimo());
            p.setEstado(dto.estado());
            p.setCodigoPedido(dto.codigoPedido());
            productoRepository.save(p);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean borrarProductoId(int id) {
        Optional<Producto> optional = productoRepository.findById(id);
        return optional.map(p -> {
            productoRepository.delete(p);
            return true;
        }).orElse(false);
    }
    */


}

