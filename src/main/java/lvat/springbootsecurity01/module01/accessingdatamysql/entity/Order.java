package lvat.springbootsecurity01.module01.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Table(name = "orders", indexes = {@Index(name = "customer_number", columnList = "customer_number")})
@Entity(name = "Order")
public class Order implements Serializable {
    @Id
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "order_date", nullable = false)
    private Calendar orderDate;

    @Column(name = "required_date", nullable = false)
    private Calendar requiredDate;

    @Column(name = "shipped_date")
    private Calendar shippedDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "comments")
    private String comments;

    @Column(name = "customer_number", nullable = false)
    private Integer customerNumber;

//    /***/
//    @ManyToMany
//    @JoinTable(name = "order_details",
//            joinColumns = {@JoinColumn(name = "order_number", nullable = false, table = "orderdetails")},
//            inverseJoinColumns = {@JoinColumn(name = "product_code", nullable = false, table = "orderdetails")})
//    private List<Product> productsList;
//    /***/
//    /*OR*/
    /***/
    @OneToMany(targetEntity = OrderDetail.class)
//    @JoinColumn(referencedColumnName = "order_number", name = "order_number", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "order_number", name = "order_number")
    private List<OrderDetail> orderDetailList;
    /***/

    @ManyToOne(targetEntity = Customer.class)
//    @JoinColumn(name = "customer_number",)
    @JoinColumn(referencedColumnName = "customer_number", name = "customer_number", insertable = false, updatable = false)
    private Customer customer;

    public Order() {
    }

    public Order(Long orderNumber, Calendar orderDate, Calendar requiredDate, Calendar shippedDate, String status, String comments, Integer customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Calendar getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Calendar requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Calendar getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Calendar shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    //    public List<Product> getProductList() {
//        return productsList;
//    }
//
//    public void setProductList(List<Product> productsList) {
//        this.productsList = productsList;
//    }
    @JsonIgnore
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        for (OrderDetail orderDetail : this.orderDetailList) {
            productList.add(orderDetail.getProduct());
        }
        return productList;
    }
}