package pe.cibertec.proy_sistema_almacen.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.cibertec.proy_sistema_almacen.dto.ProductoBajoStockDTO;
import pe.cibertec.proy_sistema_almacen.entity.Producto;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    @Query("SELECT new pe.cibertec.proy_sistema_almacen.dto.ProductoBajoStockDTO(p.idProducto, p.nombreProducto, c.nombreCategoria, m.nombreMarca, p.stockActual, p.stockMinimo) " +
            "FROM Producto p " +
            "JOIN p.categoria c " +
            "JOIN p.marca m " +
            "WHERE p.stockActual <= p.stockMinimo")
    List<ProductoBajoStockDTO> findProductosBajoStock();


}
