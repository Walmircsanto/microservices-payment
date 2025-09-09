package br.com.walmir.order.dto;

import br.com.walmir.order.model.Order;
import br.com.walmir.order.model.OrderStatus;

public class RequestOrderDTO {
    private String idRequestOrder;
    private String numberCard;
    private Integer idProduct;
    private OrderStatus orderStatus;


    public RequestOrderDTO(String idRequestOrder, String numberCard, Integer idProduct, OrderStatus orderStatus) {
        this.idRequestOrder = idRequestOrder;
        this.numberCard = numberCard;
        this.idProduct = idProduct;
        this.orderStatus = orderStatus;
    }


    public RequestOrderDTO() {
    }

    public String getIdRequestOrder() {
        return idRequestOrder;
    }

    public void setIdRequestOrder(String idRequestOrder) {
        this.idRequestOrder = idRequestOrder;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


    @Override
    public String toString() {
        return "RequestOrderDTO{" +
                "idRequestOrder='" + idRequestOrder + '\'' +
                ", numberCard='" + numberCard + '\'' +
                ", idProduct=" + idProduct +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
