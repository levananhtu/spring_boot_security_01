package lvat.springbootsecurity01.module01.accessingdatamysql.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    public OrderDetailKey() {
    }

    public OrderDetailKey(Long orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
