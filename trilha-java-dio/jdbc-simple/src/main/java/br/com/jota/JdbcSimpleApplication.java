package br.com.jota;

import br.com.jota.persistence.entiti.EmployeeDAO;
import br.com.jota.persistence.entiti.EmployeeEntity;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@SpringBootApplication
public class JdbcSimpleApplication {

    private final static EmployeeDAO EMPLOYEE_DAO = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/store", "store", "root")
                .load();
        flyway.migrate();

        /*var employee = new EmployeeEntity();
        employee.setName("Agatha Melissa Santos");
        employee.setBirthday(OffsetDateTime.now().minusYears(15));
        employee.setSalary(new BigDecimal("1900"));

        System.out.println(employee);

        EMPLOYEE_DAO.insert(employee);

        System.out.println(employee);*/

        /*EMPLOYEE_DAO.findAll().forEach(System.out::println);*/

        /*var employee = new EmployeeEntity(1, "João Victor M.", OffsetDateTime.now().minusYears(15), new BigDecimal(3500));

        EMPLOYEE_DAO.update(employee);

        System.out.println(EMPLOYEE_DAO.findById(1L));*/

        EMPLOYEE_DAO.delete(2L);
    }

}
