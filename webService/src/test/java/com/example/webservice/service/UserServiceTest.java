package com.example.webservice.service;

import com.example.webservice.model.User;
import com.example.webservice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
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

}
