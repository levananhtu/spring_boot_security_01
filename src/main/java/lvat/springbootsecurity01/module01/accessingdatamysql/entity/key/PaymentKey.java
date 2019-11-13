package lvat.springbootsecurity01.module01.accessingdatamysql.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PaymentKey implements Serializable {
    @Column(name = "customer_number", nullable = false)
    private Long customerNumber;

    @Column(name = "check_number", nullable = false)
    private String checkNumber;

    public PaymentKey() {
    }

    public PaymentKey(Long customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
