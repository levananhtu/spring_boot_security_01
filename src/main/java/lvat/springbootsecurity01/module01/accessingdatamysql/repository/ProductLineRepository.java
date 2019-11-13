package lvat.springbootsecurity01.module01.accessingdatamysql.repository;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {
}
