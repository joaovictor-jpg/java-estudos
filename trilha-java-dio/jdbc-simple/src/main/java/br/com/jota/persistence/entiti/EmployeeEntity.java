package br.com.jota.persistence.entiti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
    private long id;
    private String name;
    private OffsetDateTime birthday;
    private BigDecimal salary;
}
