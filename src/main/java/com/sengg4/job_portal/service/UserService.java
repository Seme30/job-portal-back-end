package com.sengg4.job_portal.service;
import java.util.List;

import com.sengg4.job_portal.model.User;


public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User findByUsername(String username);
    User updateUser(User user, long id);
    void deleteUser(long id);
}
