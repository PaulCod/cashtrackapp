package cashtrack.cashtrackapi.service.impl;

import cashtrack.cashtrackapi.model.User;
import cashtrack.cashtrackapi.repository.UserRepository;
import cashtrack.cashtrackapi.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public User create(User userToCreate) {

        User existingUser = userRepository.findByEmail(userToCreate.getEmail());

        if(existingUser != null) {
            throw new IllegalArgumentException("This email already use");
        }

        return userRepository.save(userToCreate);
    }

    @Override
    public User findByEmail(String userEmail) {
        User user =  userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new EntityNotFoundException("User with email" + userEmail + "not found");
        }

        return user;
    }
}
