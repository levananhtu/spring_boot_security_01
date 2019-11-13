package lvat.springbootsecurity01.module01.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "employees",
        indexes = {@Index(name = "office_code", columnList = "office_code"), @Index(name = "reports_to", columnList = "reports_to")})
@Entity(name = "Employee")
public class Employee implements Serializable {
    @Id
    @Column(name = "employee_number", nullable = false)
    private Long employeeNumber;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "office_code", nullable = false)
    private String officeCode;

    @Column(name = "reports_to")
    private Long reportsTo;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @ManyToOne
//    @JoinColumn(name = "reports_to")
    @JoinColumn(referencedColumnName = "employee_number", name = "reports_to", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
//    @JoinColumn(name = "office_code")
    @JoinColumn(referencedColumnName = "office_code", name = "office_code", insertable = false, updatable = false)
    private Office office;

    @OneToMany(targetEntity = Customer.class)
//    @JoinColumn(referencedColumnName = "employee_number", name = "sales_rep_employee_number", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "employee_number", name = "sales_rep_employee_number")
    private List<Customer> customerList;

    @OneToMany(targetEntity = Employee.class)
//    @JoinColumn(referencedColumnName = "reports_to", name = "employee_number", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "reports_to", name = "employee_number")
    private List<Employee> employeeList;

    public Employee() {
    }

    public Employee(Long employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Long reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Long getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Long reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonIgnore
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @JsonIgnore
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @JsonIgnore
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @JsonIgnore

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
