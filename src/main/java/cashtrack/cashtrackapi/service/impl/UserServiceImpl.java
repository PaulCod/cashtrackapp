package cashtrack.cashtrackapi.service.impl;

import cashtrack.cashtrackapi.dto.UserDTO;
import cashtrack.cashtrackapi.model.User;
import cashtrack.cashtrackapi.repository.UserRepository;
import cashtrack.cashtrackapi.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passEncoder;
    }

    @Override
    public User create(UserDTO userToCreate) {

        User existingUser = userRepository.findByEmail(userToCreate.getEmail());

        if(existingUser != null) {
            throw new IllegalArgumentException("This email already use");
        }

        User user = new User();
        user.setName(userToCreate.getName());
        user.setEmail(userToCreate.getEmail());
        user.setPassword(passwordEncoder.encode(userToCreate.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String userEmail) {
        User user =  userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new EntityNotFoundException("User with email" + userEmail + "not found");
        }
        return user;
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        if(!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

}
