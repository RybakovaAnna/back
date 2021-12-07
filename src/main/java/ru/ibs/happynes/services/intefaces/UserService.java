package ru.ibs.happynes.services.intefaces;

import ru.ibs.happynes.entities.UserEntity;

import java.util.List;

public interface UserService {
    void createUser(String name, String role, String password);
    UserEntity readUser(Long id);
    List<UserEntity> readAllUsers();
    void deleteUser(Long id);
    void updateUser(Long id, String name, String role, String password);
}
