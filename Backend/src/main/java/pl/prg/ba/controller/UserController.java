package pl.prg.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.entity.AuthRequest;
import pl.prg.ba.entity.UserInfo;
import pl.prg.ba.service.JwtService;
import pl.prg.ba.service.UserInfoService;
import pl.prg.ba.wrappers.SignUpResponseWrapper;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public SignUpResponseWrapper addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }
    @GetMapping("/getUsers")
    public List<UserInfo> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}