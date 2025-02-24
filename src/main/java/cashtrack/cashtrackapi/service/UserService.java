package cashtrack.cashtrackapi.service;

import cashtrack.cashtrackapi.model.User;

public interface UserService {
    User create(User userToCreate);

    User findByEmail(String userEmail);
}
