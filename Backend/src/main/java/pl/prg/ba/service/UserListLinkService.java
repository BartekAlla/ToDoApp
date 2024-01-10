package pl.prg.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.entity.UserInfo;
import pl.prg.ba.entity.UserList;
import pl.prg.ba.entity.UserListLink;
import pl.prg.ba.repository.UserListLinkRepository;
import pl.prg.ba.repository.UserListRepository;
import pl.prg.ba.repository.UserInfoRepository;


import java.util.List;
import java.util.Optional;
@Service
public class UserListLinkService {
    private UserListLinkRepository userListLinkRepository;
    private UserListRepository userListRepository;
    private UserInfoRepository userInfoRepository;

    @Autowired
    public UserListLinkService(UserListLinkRepository userListLinkRepository,
                               UserListRepository userListRepository,
                               UserInfoRepository userInfoRepository) {
        this.userListLinkRepository = userListLinkRepository;
        this.userListRepository = userListRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public UserListLink createUserListLink(UserListLink userListLink) {
        UserList userList = userListLink.getUserList();
        if (userList.getId() == null) {
            throw new IllegalArgumentException("UserList ID cannot be null");
        }
        UserList existingUserList = userListRepository.findById(userList.getId()).orElse(null);

        if (existingUserList != null) {
            userListLink.setUserList(existingUserList);



            UserInfo userInfo = userListLink.getUserInfo();
            if (userInfo.getId() == null) {
                throw new IllegalArgumentException("User ID cannot be null");
            }
            UserInfo existingUserInfo = userInfoRepository.findById(userInfo.getId()).orElse(null);

            if (existingUserInfo != null) {
                userListLink.setUserInfo(existingUserInfo);
                return userListLinkRepository.save(userListLink);
            } else {
                throw new RuntimeException("UserList with id " + userList.getId() + " not found");
            }



        } else {
            throw new RuntimeException("UserList with id " + userList.getId() + " not found");
        }
    }

    public List<UserListLink> getAllUserListLinks() {
        return userListLinkRepository.findAll();
    }





    public Optional<UserListLink> getUserListLinkById(Integer id) {
        return userListLinkRepository.findById(id);
    }


    public UserListLink updateUserListLink(Integer id, UserListLink userListLinkDetails) {
        Optional<UserListLink> userListLink = userListLinkRepository.findById(id);
        if (userListLink.isPresent()) {
            UserListLink existingUserListLink = userListLink.get();
            existingUserListLink.setUserInfo(userListLinkDetails.getUserInfo());
            existingUserListLink.setUserList(userListLinkDetails.getUserList());
            existingUserListLink.setListRole(userListLinkDetails.getListRole());
            return userListLinkRepository.save(existingUserListLink);
        }
        return null;
    }


    public void deleteAllUserListLinks() {
        userListLinkRepository.deleteAll();
    }


    public void deleteUserListLink(Integer id) {
        userListLinkRepository.deleteById(id);
    }
}
