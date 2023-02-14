package com.votre.microservices.products.business.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.votre.microservices.products.entity.User;
import com.votre.microservices.products.repository.user.IUserRepository;
import com.votre.shared.common.util.exception.config.CommonsBusinessException;


@Service
public class UserBusiness {

//    @Autowired
//    IUserClient client;

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

        return userRepository.findById(id)
                    .stream()
                    .filter(predicate)
                    .findFirst()
                    .orElseThrow(() -> new CommonsBusinessException("TEC-001", "User not found"));
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

//    public String helloWorld() {
//        return client.helloWorld();
//    }
}