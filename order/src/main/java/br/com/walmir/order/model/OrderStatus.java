package br.com.walmir.order.model;

public enum OrderStatus {
    APPROVED("approved"),
    FAILED("failed"),
    PROCESSING("processing"),
    ;

    OrderStatus(String approved) {

    }
}
