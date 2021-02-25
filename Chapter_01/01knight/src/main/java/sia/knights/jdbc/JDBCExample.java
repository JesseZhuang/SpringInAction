package sia.knights.jdbc;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {

    private MysqlDataSource dataSource;

    public JDBCExample(){
        // local MysSQL database server
        dataSource = new MysqlDataSource();
        dataSource.setUser("username");
        dataSource.setPassword("paddword");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("dbname");
    }

    // with spring template reduces boiler plate code
    public Employee getEmployeeByIDTemplate(long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject(
                "select id, firstname, lastname, salary " +
                        "from employee where id=?",
                // maps result to Employee object
                new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet rs,
                                           int rowNum) throws SQLException {
                        Employee employee = new Employee();
                        employee.setId(rs.getLong("id"));
                        employee.setFirstName(rs.getString("firstname"));
                        employee.setLastName(rs.getString("lastname"));
                        employee.setSalary(rs.getBigDecimal("salary"));
                        return employee;
                    }
                },
                id);
    }

    // too much boiler plate code
    public Employee getEmployeeById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            connection = dataSource.getConnection();
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "select id, firstname, lastname, salary from " +
                            "employee where id=?");
            statement.setLong(1, id);
            rs = statement.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstName(rs.getString("firstname"));
                employee.setLastName(rs.getString("lastname"));
                employee.setSalary(rs.getBigDecimal("salary"));
            }
            return employee;
        } catch (SQLException se) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }
}
