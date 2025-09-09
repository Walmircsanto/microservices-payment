package br.com.walmir.order.service;

import br.com.walmir.order.dto.RequestOrderDTO;
import br.com.walmir.order.dto.mapper.OrderMapper;
import br.com.walmir.order.model.Order;
import br.com.walmir.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserPlaceOrder {

    @Autowired
    private OrderRepository orderRepository;

    private KafkaTemplate<String, RequestOrderDTO> kafkaTemplate;

    public UserPlaceOrder(KafkaTemplate<String, RequestOrderDTO> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Integer idOrder) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Order order = orderRepository.findById(idOrder).orElse(null);

        kafkaTemplate.send("credit-stock",order.getId().toString(),new OrderMapper().toOrderDTO(order)); // manda a mensagem pra analise de credito e stock
        System.out.println("Order Placed Successfully");

    }


}
