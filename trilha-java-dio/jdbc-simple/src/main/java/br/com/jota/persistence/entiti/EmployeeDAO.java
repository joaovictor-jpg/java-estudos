package br.com.jota.persistence.entiti;

import br.com.jota.persistence.ConnectionUtil;
import com.mysql.cj.jdbc.StatementImpl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void insert(final EmployeeEntity entity) {
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.createStatement();
        ) {
            var sql = "INSERT INTO employees (name, birthday, salary) VALUE ('" + entity.getName() + "', '" + formatOffsetDataTime(entity.getBirthday()) + "', " + entity.getSalary().toString() + ")";
            statement.executeUpdate(sql);

            System.out.printf("Foram afetados %s registro na base de dados\n", statement.getUpdateCount());

            if (statement instanceof StatementImpl iml)
                entity.setId(iml.getLastInsertID());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity) {
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.createStatement();
        ) {
            var sql = "UPDATE employees SET " +
                    "name = '" + entity.getName() + "', " +
                    "birthday = '" + formatOffsetDataTime(entity.getBirthday()) + "', " +
                    "salary = " + entity.getSalary() + " " +
                    "WHERE id = " + entity.getId();
            statement.executeUpdate(sql);

            System.out.printf("Foram afetados %s registro na base de dados\n", statement.getUpdateCount());

            if (statement instanceof StatementImpl iml)
                entity.setId(iml.getLastInsertID());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(final Long id) {
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.createStatement();
        ) {
            var sql = "DELETE FROM employees WHERE id = " + id;

            statement.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.createStatement();
        ) {
            var sql = "SELECT * FROM employees ORDER BY name";

            statement.executeQuery(sql);

            var result = statement.getResultSet();

            while (result.next()) {
                var birthdayInstance = result.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstance, ZoneOffset.UTC);
                employees.add(new EmployeeEntity(result.getLong("id"), result.getString("name"), birthday, result.getBigDecimal("salary")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return employees;
    }

    public EmployeeEntity findById(final Long id) {
        EmployeeEntity employee = new EmployeeEntity();
        try (var connection = ConnectionUtil.getConnection();
             var statement = connection.createStatement();
        ) {
            var sql = "SELECT * FROM employees WHERE id = " + id;

            statement.executeQuery(sql);

            var result = statement.getResultSet();
            if (result.next()) {
                var birthdayInstance = result.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstance, ZoneOffset.UTC);
                employee = new EmployeeEntity(result.getLong("id"), result.getString("name"), birthday, result.getBigDecimal("salary"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    private String formatOffsetDataTime(final OffsetDateTime dateTime) {
        var utcDateTime = dateTime.withOffsetSameInstant(ZoneOffset.UTC);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
