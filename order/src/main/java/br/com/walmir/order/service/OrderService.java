package br.com.walmir.order.service;

import br.com.walmir.order.dto.ResponseOrderDTO;
import br.com.walmir.order.dto.mapper.OrderMapper;
import br.com.walmir.order.model.Order;
import br.com.walmir.order.model.OrderStatus;
import br.com.walmir.order.repository.OrderRepository;
import br.com.walmir.order.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = (List<Order>) this.orderRepository.findAll();
        return orders.stream()
                .filter(x-> x.getStatus() == OrderStatus.PROCESSING)
                .toList();
    }

    public List<Order> getAllOrdersByStatus() {

        return  (List<Order>) this.orderRepository.findAll();
    }


    public ResponseOrderDTO createdOrder(Order order, int idUser ){
        order.setUser(this.userService.getUserById(idUser));
        order.setStatus(OrderStatus.PROCESSING);
        return new OrderMapper().toResponseDTO(this.orderRepository.save(order));

    }

    public Optional<Order> getOrderById(Integer id){
        return  this.orderRepository.findById(id);
    }
}
