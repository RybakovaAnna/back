package ru.ibs.happynes.controllers;

import org.springframework.web.bind.annotation.*;
import ru.ibs.happynes.entities.UserEntity;
import ru.ibs.happynes.services.intefaces.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostConstruct
//    private void postConstruct(){
//        userService.createUser("Anna", "Manager", "password");
//        userService.createUser("Dima", "developer", "password");
//    }

    @GetMapping("read")
    private Object readUser(@RequestParam(required = false) Long id){
        if (id != null){
            return userService.readUser(id);
        }
        else {
            return userService.readAllUsers();
        }
    }

    @PostMapping("create")
    private void createUser(@RequestBody UserEntity userEntity){
        userService.createUser(userEntity.getName(), userEntity.getRole(), userEntity.getPassword());
    }

    @PostMapping("delete")
    private void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }

    @PostMapping("update")
    private void updateUser(@RequestParam Long id, @RequestBody UserEntity userEntity){
        userService.updateUser(id, userEntity.getName(), userEntity.getRole(), userEntity.getPassword());
    }
}
