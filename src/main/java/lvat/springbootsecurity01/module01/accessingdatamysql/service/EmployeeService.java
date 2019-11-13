package lvat.springbootsecurity01.module01.accessingdatamysql.service;

import lvat.springbootsecurity01.module01.accessingdatamysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final static int SIZE = 20;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public <T> List<T> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Class<T> type, Integer page) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName, lastName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> List<T> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Class<T> type, Integer page) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> T findByEmployeeNumber(Long employeeNumber, Class<T> type) {
        return employeeRepository.findByEmployeeNumber(employeeNumber, type);
    }
}
