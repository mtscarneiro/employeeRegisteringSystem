package com.mtscarneiro.cconecte.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "mtscarneiroemp", name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "EMPLOYEE_NAME")
    private String name;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "WORK_DAYS")
    private Integer workDays;
    @Column(name = "DAYS_OFF")
    private Integer daysOff;
    @Column(name = "HOUR_PRICE")
    private Double hourPrice;

    public Employee(Long id, String name, String title,
                    Integer workDays, Integer daysOff, Double hourPrice) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.workDays = workDays;
        this.daysOff = daysOff;
        this.hourPrice = hourPrice;
    }
}
