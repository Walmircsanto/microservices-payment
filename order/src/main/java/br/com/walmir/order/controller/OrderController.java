package br.com.walmir.order.controller;

import br.com.walmir.order.dto.ResponseOrderDTO;
import br.com.walmir.order.model.Order;

import br.com.walmir.order.service.OrderService;
import br.com.walmir.order.service.UserPlaceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private UserPlaceOrder userPlaceOrder;

    @Autowired
    private OrderService orderService;

    @PostMapping("/verify/{idOrder}")
   public ResponseEntity<String> sendMessagePayment(@PathVariable int idOrder) throws UnsupportedEncodingException, NoSuchAlgorithmException {
      userPlaceOrder.placeOrder(idOrder);
      return new ResponseEntity<>("Order Placed Successfully", HttpStatus.OK);
   }


   @PostMapping("/creted/{idUser}")
   public ResponseEntity<ResponseOrderDTO> createOrder(@RequestBody Order order, @PathVariable int idUser){
        return new ResponseEntity<>(this.orderService.createdOrder(order, idUser), HttpStatus.CREATED);
   }


   @GetMapping
   public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(this.orderService.getAllOrders(), HttpStatus.OK);
   }
}
