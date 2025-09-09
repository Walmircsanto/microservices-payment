package br.com.walmir.order.configs;

import br.com.walmir.order.dto.RequestOrderDTO;
import br.com.walmir.order.model.Order;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductorKafkaConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

   @Bean
    public ProducerFactory<String, RequestOrderDTO> producer(){
       Map<String, Object> config = new HashMap<>();
       config.put("bootstrap.servers",bootstrapServers); // onde o kafka esta rodando
       config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");// serializa chaves como string
       config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Serializa valores como JSON
       config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);//Não adicionar metadados
       return new DefaultKafkaProducerFactory<>(config);

   }

   @Bean
    public KafkaTemplate<String, RequestOrderDTO> kafkaTemplate(){
     return new KafkaTemplate<>(producer());
   }
}
