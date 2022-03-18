//package com.example.demo.service;
//
//import org.apache.catalina.User;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImp implements UserService{
//
//    private final UserRepository userRepository;
//
//    public UserServiceImp(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public void saveUser(User user) {
//        user.setPassword(user.getPassword());
//        userRepository.save(user);
//    }
//
//    @Override
//    public List<User> finaAll() {
//        return userRepository.findAll();
//    }
//}
