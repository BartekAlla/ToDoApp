package pl.prg.ba.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Repository.UserListRepository;



import java.util.List;
import java.util.Optional;

@Service
public class UserListService {
    @Autowired
    private UserListRepository userListRepository;

    // Create a new list
    public UserList createList(UserList list) {
        return userListRepository.save(list);
    }

    // Get all lists
    public List<UserList> getAllLists() {
        return userListRepository.findAll();
    }

    // Get list by ID
    public Optional<UserList> getListById(Integer id) {
        return userListRepository.findById(id);
    }

    // Update list
    public UserList updateList(Integer id, UserList listDetails) {
        Optional<UserList> list = userListRepository.findById(id);
        if (list.isPresent()) {
            UserList existingList = list.get();
            existingList.setName(listDetails.getName());
            existingList.setListType(listDetails.getListType());
            // Set other fields as needed
            return userListRepository.save(existingList);
        }
        return null;
    }

    // Delete all lists
    public void deleteAllLists() {
        userListRepository.deleteAll();
    }

    // Delete list
    public void deleteList(Integer id) {
        userListRepository.deleteById(id);
    }

    public List<UserList> getPublicLists() {
        return userListRepository.findPublicLists();
    }

}