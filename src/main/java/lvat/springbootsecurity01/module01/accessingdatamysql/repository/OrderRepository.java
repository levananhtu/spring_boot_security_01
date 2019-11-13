package lvat.springbootsecurity01.module01.accessingdatamysql.repository;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
