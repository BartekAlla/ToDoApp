package pl.prg.ba.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Repository.ListRepository;



import java.util.List;
import java.util.Optional;

@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    // Create a new list
    public UserList createList(UserList list) {
        return listRepository.save(list);
    }

    // Get all lists
    public List<UserList> getAllLists() {
        return listRepository.findAll();
    }

    // Get list by ID
    public Optional<UserList> getListById(Integer id) {
        return listRepository.findById(id);
    }

    // Update list
    public UserList updateList(Integer id, UserList listDetails) {
        Optional<UserList> list = listRepository.findById(id);
        if (list.isPresent()) {
            UserList existingList = list.get();
            existingList.setName(listDetails.getName());
            existingList.setListType(listDetails.getListType());
            // Set other fields as needed
            return listRepository.save(existingList);
        }
        return null;
    }

    // Delete all lists
    public void deleteAllLists() {
        listRepository.deleteAll();
    }

    // Delete list
    public void deleteList(Integer id) {
        listRepository.deleteById(id);
    }

    // Other business logic related to lists
}