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
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private Integer workDays;
    private Integer daysOff;
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
