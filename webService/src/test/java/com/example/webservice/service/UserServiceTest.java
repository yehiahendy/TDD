package com.example.webservice.service;

import com.example.webservice.model.User;
import com.example.webservice.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@DisplayName("User Service Test Class")
public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;



    @TestConfiguration
    static class UserServiceContextConfiguration {
        @Bean
        public UserService todoService() {
            return new UserService();
        }
    }
    @Test
    @DisplayName("Calculate the users average")
    public void getAllGrades_andCalcAverage() {
        // Create fake data
        User firstUser = new User("1", "Yehia", 50);
        User secondUser = new User("2", "Ahmed", 40);
        User thirdUser = new User("3", "Mohamed", 60);
        User fourthUser = new User("4", "Youssef", 100);
        List<User> userList = Arrays.asList(firstUser, secondUser, thirdUser, fourthUser);
        given(userRepository.findAll()).willReturn(userList);
        float average = 62.5F;
        assertThat(userService.calcAverage()).isEqualTo(average);
    }
    @Test
    @DisplayName("Calculate the users average when there's no data ")
    public void getAllGrades_andCalcAverageWhenUsersAreNull()
    {
        List<User> users = new ArrayList<>();
        given(userRepository.findAll()).willReturn(users);
        assertThat(userService.calcAverage()).isEqualTo(0f);
    }


}
