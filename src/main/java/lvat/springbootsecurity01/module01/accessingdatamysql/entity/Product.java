package lvat.springbootsecurity01.module01.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "products",
        indexes = {@Index(name = "product_line", columnList = "product_line")})
@Entity(name = "Product")
public class Product implements Serializable {
    @Id
    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_line", nullable = false)
    private String productLine;

    @Column(name = "product_scale", nullable = false)
    private String productScale;

    @Column(name = "product_vendor", nullable = false)
    private String productVendor;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "quantity_in_stock", nullable = false)
    private String quantityInStock;

    @Column(name = "buy_price", nullable = false)
    private String buyPrice;

    @Column(name = "MSRP", nullable = false)
    private String msrp;

//    /***/
//    @ManyToMany
//    @JoinTable(name = "order_details",
//            inverseJoinColumns = {@JoinColumn(name = "order_number", nullable = false, table = "orderdetails")},
//            joinColumns = {@JoinColumn(name = "product_code", nullable = false, table = "orderdetails")})
//    private List<Order> ordersList;
//    /***/
//    /*OR*/
    /***/
    @OneToMany(targetEntity = OrderDetail.class)
//    @JoinColumn(referencedColumnName = "product_code", name = "product_code", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "product_code", name = "product_code")
    private List<OrderDetail> orderDetailList;
    /***/

    @ManyToOne
//    @JoinColumn(name = "product_line")
    @JoinColumn(referencedColumnName = "product_line", name = "product_line", insertable = false, updatable = false)
    private ProductLine lines;

    public Product() {
    }

    public Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, String quantityInStock, String buyPrice, String msrp) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

//    public List<Order> getOrderList() {
//        return ordersList;
//    }
//
//    public void setOrderList(List<Order> ordersList) {
//        this.ordersList = ordersList;
//    }

    @JsonIgnore
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @JsonIgnore
    public ProductLine getLines() {
        return lines;
    }

    public void setLines(ProductLine lines) {
        this.lines = lines;
    }

    public List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        for (OrderDetail orderDetail :
                this.orderDetailList) {
            orderList.add(orderDetail.getOrder());
        }
        return orderList;
    }
}
