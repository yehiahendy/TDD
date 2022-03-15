package com.example.webservice.service;

import com.example.webservice.model.User;
import com.example.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public float calcAverage()
    {
        return 0f;
    }
}
