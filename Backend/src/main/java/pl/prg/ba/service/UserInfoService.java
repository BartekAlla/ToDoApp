package pl.prg.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.prg.ba.entity.UserInfo;
import pl.prg.ba.repository.UserInfoRepository;
import pl.prg.ba.wrappers.CredentialsWrapper;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userDetail = repository.findByEmail(username);

        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
    public List<UserInfo> getAllUsers() {
        return repository.findAll();
    }
    public CredentialsWrapper addUser(UserInfo userInfo) {
        if (!isValidEmail(userInfo.getEmail())) {
            return new CredentialsWrapper(false, "Wrong email format.");
        }
        Optional<UserInfo> emailEntry = repository.findByEmail(userInfo.getEmail());
        if(emailEntry.isPresent()){
            return new CredentialsWrapper(false, "User with provided e-mail already exists.");
        }
        if (!isValidPassword(userInfo.getPassword())){
            return new CredentialsWrapper(false, "Password must contain 8 characters, one number, one capitalized letter, and one special sign.");
        }
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return new CredentialsWrapper(true, "User Added Successfully");
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}