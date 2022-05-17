package com.sengg4.job_portal.service.implementation;

import java.util.List;
// import java.util.Optional;

import com.sengg4.job_portal.exception.ResourceNotFoundException;
import com.sengg4.job_portal.model.User;
import com.sengg4.job_portal.repository.UserRepository;
import com.sengg4.job_portal.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        // Optional<User> user = userRepository.findById(id);
        // if(user.isPresent()){
        //     return user.get();
        // }
        // else{
        //     throw new ResourceNotFoundException("User", "Id", id);
        // }
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setUsername(user.getUsername());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
        userRepository.deleteById(id);    
    }

    @Override
    public User findByUsername(String username) {
        try{
            return userRepository.findByUserName(username);
        }catch(Exception ex){
            throw  new ResourceNotFoundException("User", "username", username);
        }
    
    }
    
    
}
