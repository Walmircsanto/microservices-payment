package br.com.walmir.order.controller;

import br.com.walmir.order.model.User;

import br.com.walmir.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<User> createdUser( @RequestBody User user){
        return  new ResponseEntity<>(this.userService.createdUser(user), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        return new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);
    }
}
