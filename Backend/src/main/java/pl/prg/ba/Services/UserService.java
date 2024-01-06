package pl.prg.ba.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.Model.User;
import pl.prg.ba.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }


    public User updateUser(Integer id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            setExistingUserData(user.get(), userDetails);
        }
        return null;
    }

    private void setExistingUserData(User existingUser, User userDetails) {
        existingUser.setName(userDetails.getName());
        existingUser.setSurname(userDetails.getSurname());
        existingUser.setGender(userDetails.getGender());
        existingUser.setAge(userDetails.getAge());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPassword(userDetails.getPassword());
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }


    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}