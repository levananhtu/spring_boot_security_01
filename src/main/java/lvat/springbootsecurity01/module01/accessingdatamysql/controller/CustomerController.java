package lvat.springbootsecurity01.module01.accessingdatamysql.controller;

import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Customer;
import lvat.springbootsecurity01.module01.accessingdatamysql.entity.Order;
import lvat.springbootsecurity01.module01.accessingdatamysql.entity.projection.customer.CustomerProjection;
import lvat.springbootsecurity01.module01.accessingdatamysql.entity.projection.customer.CustomerProjection01;
import lvat.springbootsecurity01.module01.accessingdatamysql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path = "/by-customer-number", method = RequestMethod.GET)
    public CustomerProjection getCustomersByCustomerNumber(@RequestParam(value = "customer-number", defaultValue = "145") Long customerNumber) {
        return customerService.getCustomersByCustomerNumber(customerNumber, CustomerProjection01.class);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customerService.getAllCustomers(page, Customer.class);
    }

    @RequestMapping(path = "/by-customer-name", method = RequestMethod.GET)
    public List<Customer> getCustomersByCustomerName(@RequestParam(value = "customer-name", defaultValue = "") String customerName, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customerService.getCustomersByCustomerName(customerName, Customer.class, page);
    }

    @RequestMapping(path = "/by-country-and-state", method = RequestMethod.GET)
    public List<Customer> getCustomersByCountryAndState(@RequestParam(value = "country", defaultValue = "") String country, @RequestParam(value = "state", defaultValue = "") String state, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customerService.getCustomersByCountryAndState(country, state, Customer.class, page);
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public List<List<Order>> getOrdersByCustomerNumber(@RequestParam(value = "customer-number", defaultValue = "145") Long customerNumber) {
        return customerService.getOrdersByCustomerNumber(customerNumber);
    }

    @RequestMapping(path = "/cn-cl", method = RequestMethod.GET)
    public List<Customer> getByCustomerNameAndCreditLimit(@RequestParam(value = "customer-name", defaultValue = "") String customerName,
                                                          @RequestParam(value = "credit-limit", defaultValue = "100000") Double creditLimit,
                                                          @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return customerService.getByCustomerNameAndCreditLimit(customerName, creditLimit, Customer.class, page);
    }
}