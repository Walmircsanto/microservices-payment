package br.com.walmir.order.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // FK vai ser user_id
    private User user;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Date orderDate;

    @Column(nullable = false)
    private String idOrder;


    private  int productId;


    public Order() {
    }

    public Order(Integer id, User user, OrderStatus status, Date orderDate, String idOrder) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.orderDate = orderDate;
        this.idOrder = idOrder;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", idOrder='" + idOrder + '\'' +
                '}';
    }
}
