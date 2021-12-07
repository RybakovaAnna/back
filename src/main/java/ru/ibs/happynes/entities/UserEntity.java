package ru.ibs.happynes.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String role;

    private String password;

    public UserEntity(String name, String role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.join(name, role, password);
    }
}
