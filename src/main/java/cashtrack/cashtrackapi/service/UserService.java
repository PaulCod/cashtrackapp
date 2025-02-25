package cashtrack.cashtrackapi.service;

import cashtrack.cashtrackapi.dto.UserDTO;
import cashtrack.cashtrackapi.model.User;

public interface UserService {
    User create(UserDTO userToCreate);

    User findByEmail(String userEmail);

    User updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
