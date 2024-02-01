package pl.prg.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.entity.UserList;
import pl.prg.ba.entity.UserListLink;
import pl.prg.ba.repository.UserListLinkRepository;
import pl.prg.ba.repository.UserListRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserListService {

    private UserListRepository userListRepository;
    private UserListLinkRepository userListLinkRepository;

    @Autowired
    public UserListService(UserListRepository userListRepository, UserListLinkRepository userListLinkRepository) {
        this.userListRepository = userListRepository;
        this.userListLinkRepository = userListLinkRepository;

    }

    public UserList createList(UserList userList) {
        return userListRepository.save(userList);
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

    public List<UserListLink> getUserListLinksByUserId(Integer userId) {
        return this.userListLinkRepository.getUserListLinksByUserId(userId);
    }
}