//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.07.01 a las 12:09:44 PM PET 
//


package pe.cibertec.proy_sistema_almacen.ws.categoria;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.cibertec.proy_sistema_almacen.ws.categoria package. 
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

    private final static QName _CategoriaListarRequest_QNAME = new QName("http://pe.cibertec/ws/categoria", "CategoriaListarRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.cibertec.proy_sistema_almacen.ws.categoria
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CategoriaCrearRequest }
     * 
     */
    public CategoriaCrearRequest createCategoriaCrearRequest() {
        return new CategoriaCrearRequest();
    }

    /**
     * Create an instance of {@link Categoria }
     * 
     */
    public Categoria createCategoria() {
        return new Categoria();
    }

    /**
     * Create an instance of {@link CategoriaCrearResponse }
     * 
     */
    public CategoriaCrearResponse createCategoriaCrearResponse() {
        return new CategoriaCrearResponse();
    }

    /**
     * Create an instance of {@link CategoriaListarResponse }
     * 
     */
    public CategoriaListarResponse createCategoriaListarResponse() {
        return new CategoriaListarResponse();
    }

    /**
     * Create an instance of {@link CategoriaModificarRequest }
     * 
     */
    public CategoriaModificarRequest createCategoriaModificarRequest() {
        return new CategoriaModificarRequest();
    }

    /**
     * Create an instance of {@link CategoriaModificarResponse }
     * 
     */
    public CategoriaModificarResponse createCategoriaModificarResponse() {
        return new CategoriaModificarResponse();
    }

    /**
     * Create an instance of {@link CategoriaEliminarRequest }
     * 
     */
    public CategoriaEliminarRequest createCategoriaEliminarRequest() {
        return new CategoriaEliminarRequest();
    }

    /**
     * Create an instance of {@link CategoriaEliminarResponse }
     * 
     */
    public CategoriaEliminarResponse createCategoriaEliminarResponse() {
        return new CategoriaEliminarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://pe.cibertec/ws/categoria", name = "CategoriaListarRequest")
    public JAXBElement<Object> createCategoriaListarRequest(Object value) {
        return new JAXBElement<Object>(_CategoriaListarRequest_QNAME, Object.class, null, value);
    }

}
