//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.07.01 a las 01:19:08 PM PET 
//


package pe.cibertec.proy_sistema_almacen.ws.producto;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.cibertec.proy_sistema_almacen.ws.producto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProductoListarRequest_QNAME = new QName("http://pe.cibertec/ws/producto", "ProductoListarRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.cibertec.proy_sistema_almacen.ws.producto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductoCrearRequest }
     * 
     */
    public ProductoCrearRequest createProductoCrearRequest() {
        return new ProductoCrearRequest();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link ProductoCrearResponse }
     * 
     */
    public ProductoCrearResponse createProductoCrearResponse() {
        return new ProductoCrearResponse();
    }

    /**
     * Create an instance of {@link ProductoListarResponse }
     * 
     */
    public ProductoListarResponse createProductoListarResponse() {
        return new ProductoListarResponse();
    }

    /**
     * Create an instance of {@link ProductoModificarRequest }
     * 
     */
    public ProductoModificarRequest createProductoModificarRequest() {
        return new ProductoModificarRequest();
    }

    /**
     * Create an instance of {@link ProductoModificarResponse }
     * 
     */
    public ProductoModificarResponse createProductoModificarResponse() {
        return new ProductoModificarResponse();
    }

    /**
     * Create an instance of {@link ProductoEliminarRequest }
     * 
     */
    public ProductoEliminarRequest createProductoEliminarRequest() {
        return new ProductoEliminarRequest();
    }

    /**
     * Create an instance of {@link ProductoEliminarResponse }
     * 
     */
    public ProductoEliminarResponse createProductoEliminarResponse() {
        return new ProductoEliminarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://pe.cibertec/ws/producto", name = "ProductoListarRequest")
    public JAXBElement<Object> createProductoListarRequest(Object value) {
        return new JAXBElement<Object>(_ProductoListarRequest_QNAME, Object.class, null, value);
    }

}
