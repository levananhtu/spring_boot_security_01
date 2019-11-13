package lvat.springbootsecurity01.module01.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lvat.springbootsecurity01.module01.accessingdatamysql.entity.key.OrderDetailKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OrderDetail")
@Table(name = "order_details", indexes = {@Index(name = "product_code", columnList = "product_code")})
public class OrderDetail implements Serializable {
    @EmbeddedId
    private OrderDetailKey orderDetailKey;

    @Column(name = "quantity_ordered", nullable = false)
    private Long quantityOrdered;

    @Column(name = "price_each", nullable = false)
    private Double priceEach;

    @Column(name = "order_line_number", nullable = false)
    private Integer orderLineNumber;

    @ManyToOne
//    @MapsId(value = "order_number")
//    @JoinColumn(name = "order_number")
    @JoinColumn(referencedColumnName = "order_number", name = "order_number", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
//    @MapsId(value = "product_code")
//    @JoinColumn(name = "product_code")
    @JoinColumn(referencedColumnName = "product_code", name = "product_code", insertable = false, updatable = false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailKey orderDetailKey, Long quantityOrdered, Double priceEach, Integer orderLineNumber) {
        this.orderDetailKey = orderDetailKey;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetail(Long orderNumber, String productCode, Long quantityOrdered, Double priceEach, Integer orderLineNumber) {
        this.orderDetailKey = new OrderDetailKey(orderNumber, productCode);
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetailKey getOrderDetailKey() {
        return orderDetailKey;
    }

    public void setOrderDetailKey(OrderDetailKey orderDetailKey) {
        this.orderDetailKey = orderDetailKey;
    }

    public Long getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Long quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
// **