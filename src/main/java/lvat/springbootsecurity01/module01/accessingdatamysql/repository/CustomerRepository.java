package lvat.springbootsecurity01.module01.accessingdatamysql.repository;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    <T> Page<T> findByCustomerNameContaining(String customerName, Class<T> type, Pageable pageable);

    <T> Page<T> findByCountryAndState(String country, String state, Class<T> type, Pageable pageable);

    <T> Page<T> findByCustomerNameContainingAndCreditLimitLessThanEqual(String customerName, Double creditLimit, Class<T> type, Pageable pageable);

    <T> T findByCustomerNumber(Long customerNumber, Class<T> type);

    <T> Page<T> findAllCustomersBy(Class<T> type, Pageable pageable);

}
