package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    void saveUser(User user);
    User findUser(long id);
    void updateUser(User user);
    void deleteUser(User user);

}
