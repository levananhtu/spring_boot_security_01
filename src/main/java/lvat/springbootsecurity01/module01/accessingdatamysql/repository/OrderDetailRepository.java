package lvat.springbootsecurity01.module01.accessingdatamysql.repository;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
