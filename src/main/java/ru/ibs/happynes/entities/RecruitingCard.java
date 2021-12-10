package ru.ibs.happynes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class RecruitingCard {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private Long id;

    private String fullName;

    private String contacts;

    @JoinColumn(name = "recruiting_card_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Employee> employeesLists;

}