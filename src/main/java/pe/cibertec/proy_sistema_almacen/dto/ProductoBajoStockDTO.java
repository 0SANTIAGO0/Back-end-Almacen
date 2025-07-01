package pe.cibertec.proy_sistema_almacen.dto;

public class ProductoBajoStockDTO {

    private Integer idProducto;
    private String nombreProducto;
    private String nombreCategoria;
    private String nombreMarca;
    private Integer stockActual;
    private Integer stockMinimo;

    public ProductoBajoStockDTO() {
    }

    public ProductoBajoStockDTO(Integer idProducto, String nombreProducto, String nombreCategoria,
                                String nombreMarca, Integer stockActual, Integer stockMinimo) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.nombreCategoria = nombreCategoria;
        this.nombreMarca = nombreMarca;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}

