package com.devglan.controller;


import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> listUser(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable int id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public Void delete(@PathVariable int id) {
        userService.delete(id);
        return null;
    }



}
