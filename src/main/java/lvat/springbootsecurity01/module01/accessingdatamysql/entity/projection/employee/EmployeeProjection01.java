package lvat.springbootsecurity01.module01.accessingdatamysql.entity.projection.employee;

public class EmployeeProjection01 extends EmployeeProjection {
    private Long employeeNumber;

    private String lastName;

    private String firstName;

    public EmployeeProjection01(Long employeeNumber, String lastName, String firstName) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
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
}
