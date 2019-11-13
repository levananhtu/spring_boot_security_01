package lvat.springbootsecurity01.module01.accessingdatamysql.service;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Customer;
import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Order;
import lvat.springbootsecurity01.module01.accessingdatamysql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final static int SIZE = 20;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public <T> T getCustomersByCustomerNumber(Long customerNumber, Class<T> type) {
        return customerRepository.findByCustomerNumber(customerNumber, type);
    }

    public <T> List<T> getAllCustomers(Integer page, Class<T> type) {
        return customerRepository.findAllCustomersBy(type, PageRequest.of(0, 20)).get().collect(Collectors.toList());
    }

    public <T> List<T> getCustomersByCustomerName(String customerName, Class<T> type, Integer page) {
        return customerRepository.findByCustomerNameContaining(customerName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> List<T> getCustomersByCountryAndState(String country, String state, Class<T> type, Integer page) {
        return customerRepository.findByCountryAndState(country, state, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public List<List<Order>> getOrdersByCustomerNumber(Long customerNumber) {
        List<List<Order>> ordersList = new LinkedList<>();
        Customer customer = customerRepository.findByCustomerNumber(customerNumber, Customer.class);
        ordersList.add(customer.getOrderList());
        return ordersList;
    }

    public <T> List<T> getByCustomerNameAndCreditLimit(String customerName, Double creditLimit, Class<T> type, Integer page) {
        return customerRepository.findByCustomerNameContainingAndCreditLimitLessThanEqual(customerName, creditLimit, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }
}
