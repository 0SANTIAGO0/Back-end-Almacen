package pe.cibertec.proy_sistema_almacen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Constantes
    public static final String QUEUE_NAME = "mensaje_consultor_queue";
    public static final String EXCHANGE_NAME = "mensaje_consultor_exchange";
    public static final String ROUTING_KEY = "mensaje_consultor_routing_key";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true); // durable = true
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}