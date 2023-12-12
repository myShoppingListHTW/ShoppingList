/** package service;

import Entities.UserEntity;
import Objects.User;
import Repos.UserRepo;
import org.springframework.stereotype.Service;
import web.Transformers.UserTransformer;

import java.util.List;


public class UserService {

    private final UserRepo userRepository;
    private final UserTransformer userTransformer;

    public UserService(UserRepo userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    public void saveUser(User user) {
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        UserEntity userEntity = userTransformer.transformToEntity(user);
        userRepository.save(userEntity);
    }

    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(userTransformer::transformEntity).orElse(null);
    }

    public List<UserEntity> findAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
**/