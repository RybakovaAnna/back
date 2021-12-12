package ru.ibs.happynes.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class EmployeeA {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullAnalyticName;

    private String phoneAnalyticNumber;

    private String emailAnalytic;
}
