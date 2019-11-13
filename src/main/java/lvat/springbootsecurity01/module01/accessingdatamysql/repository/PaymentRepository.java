package lvat.springbootsecurity01.module01.accessingdatamysql.repository;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
