package br.com.walmir.order.service;

import br.com.walmir.order.model.User;
import br.com.walmir.order.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id){
        return this.userRepository.findById(id).orElse(null);
    }

    public User createdUser(User user){
        return this.userRepository.save(user);
    }
}
