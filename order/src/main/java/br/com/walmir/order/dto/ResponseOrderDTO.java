package br.com.walmir.order.dto;

import br.com.walmir.order.model.OrderStatus;

public record ResponseOrderDTO ( String idRequestOrder,
         String numberCard,
         Integer idProduct,
         OrderStatus orderStatus){}
