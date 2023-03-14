package com.example.eCommerce.Controller;

import com.example.eCommerce.Model.User;
import com.example.eCommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
}
