package pl.prg.ba.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.prg.ba.Model.User;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Repository.UserListRepository;
import pl.prg.ba.Repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserListService {

    private UserListRepository userListRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserListService(UserListRepository userListRepository, UserRepository userRepository) {
        this.userListRepository = userListRepository;
        this.userRepository = userRepository;
    }

    public UserList createList(UserList list) {
        User user = list.getUser();
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if (existingUser != null) {
            list.setUser(existingUser);
            return userListRepository.save(list);
        } else {
            throw new RuntimeException("User with id " + user.getId() + " not found");
        }
    }

    public List<UserList> getAllLists() {
        return userListRepository.findAll();
    }


    public Optional<UserList> getListById(Integer id) {
        return userListRepository.findById(id);
    }


    public UserList updateList(Integer id, UserList listDetails) {
        Optional<UserList> list = userListRepository.findById(id);
        if (list.isPresent()) {
            UserList existingList = list.get();
            existingList.setName(listDetails.getName());
            existingList.setListType(listDetails.getListType());
            return userListRepository.save(existingList);
        }
        return null;
    }


    public void deleteAllLists() {
        userListRepository.deleteAll();
    }


    public void deleteList(Integer id) {
        userListRepository.deleteById(id);
    }

    public List<UserList> getPublicLists() {
        return userListRepository.findPublicLists();
    }

}