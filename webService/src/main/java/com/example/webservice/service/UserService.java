package com.example.webservice.service;

import com.example.webservice.model.User;
import com.example.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public float calcAverage() {
        float count = 0;
        //get data from database
        List<User> users = userRepository.findAll();

        for (User user : users) count += user.getDegree();
        return count / users.size();

    }
}
