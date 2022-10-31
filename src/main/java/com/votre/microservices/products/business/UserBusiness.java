package com.votre.microservices.products.business;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.votre.configuration.CommonsBusinessException;
import com.votre.microservices.products.entity.User;
import com.votre.microservices.products.repository.IUserRepository;

@Service
public class UserBusiness {

    private IUserRepository userRepository;
    private int usersCount = 0;
    private List<User> users = new ArrayList<>();

    public UserBusiness(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return userRepository.save(user);
    }

    public User findOne(int id) {

        Predicate<? super User> predicate = user -> user.getId().equals(id);

        User user = userRepository.findById(id).stream().filter(predicate).findFirst()
                        .orElseThrow(() -> new CommonsBusinessException("TEC-001", "User not found"));

        return user;
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
