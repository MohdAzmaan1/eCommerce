package com.example.eCommerce.Service;

import com.example.eCommerce.Model.User;
import com.example.eCommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user) {
        userRepository.save(user);
        return "User Added Successfully";
    }
}
