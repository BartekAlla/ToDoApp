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
import pl.prg.ba.wrappers.CredentialsWrapper;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public CredentialsWrapper addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
    public CredentialsWrapper authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return new CredentialsWrapper(true,
                    jwtService.generateToken(authRequest.getUsername()),
                    this.service.getUserIdByUsername(authRequest.getUsername()));
        } else {
            return new CredentialsWrapper(false, "Invalid username or password.");
        }
    }
}