package sia.knights.jdbc;

import java.math.BigDecimal;

public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
