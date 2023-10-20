package vinicius.mywebapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vinicius.mywebapi.model.User;
import vinicius.mywebapi.repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    UserRepository repository;

    @GetMapping
    public String welcomeUsers(){
        StringBuilder values = new StringBuilder();
        for (User u:
             repository.findAll()) {
            values.append(u.toString());
        }
        return "IS USERS" + values;
    }


    public String hello() {
        return "Hello!";
    }

    @GetMapping("/admin")
    public String getOneUser(@PathVariable("id") Integer id ){
        return "Is Adm ="+repository.findById(1).toString();
    }

    @GetMapping("/users/{id}")
    public String getById(@PathVariable("id") Integer id ){
       return repository.findById(id).toString();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id ){
        repository.deleteById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody User user){
        System.out.println(user);
        repository.save(user);
    }

    @PutMapping("/users/{username}")
    public void putUser(@PathVariable String username,@RequestBody User newUser){

        List<User> filterUser;
        filterUser = repository.findAll().stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList());
        System.out.println("oi"+filterUser);
        repository.deleteAll(filterUser);
        repository.save(newUser);
    }
}
