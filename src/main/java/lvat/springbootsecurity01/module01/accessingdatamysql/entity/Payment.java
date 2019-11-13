package lvat.springbootsecurity01.module01.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lvat.springbootsecurity01.module01.accessingdatamysql.entity.key.PaymentKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Table(name = "payments")
@Entity(name = "Payment")
public class Payment implements Serializable {
    @EmbeddedId
    private PaymentKey paymentKey;

    @Column(name = "payment_date", nullable = false)
    private Calendar paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
//    @JoinColumn(name = "customer_number")
    @JoinColumn(referencedColumnName = "customer_number", name = "customer_number", insertable = false, updatable = false)
    private Customer customer;

    public Payment() {
    }

    public Payment(PaymentKey paymentKey, Calendar paymentDate, Double amount, Customer customer) {
        this.paymentKey = paymentKey;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.customer = customer;
    }

    public Payment(Long customerNumber, String checkNumber, Calendar paymentDate, Double amount, Customer customer) {
        this.paymentKey = new PaymentKey(customerNumber, checkNumber);
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.customer = customer;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentKey getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(PaymentKey paymentKey) {
        this.paymentKey = paymentKey;
    }

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
