package pe.cibertec.proy_sistema_almacen.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "categorias")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema categoriaSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CategoriaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://pe.cibertec/ws/categoria");

        wsdl11Definition.setSchema(categoriaSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema categoriaSchema() {
        return new SimpleXsdSchema(new ClassPathResource("categoria.xsd"));
    }

    @Bean(name = "productos")
    public DefaultWsdl11Definition productosWsdl11Definition(XsdSchema productoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://pe.cibertec/ws/producto");
        wsdl11Definition.setSchema(productoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema productoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("producto.xsd"));
    }
}