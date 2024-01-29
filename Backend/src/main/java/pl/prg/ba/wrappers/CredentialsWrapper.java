package pl.prg.ba.wrappers;

import lombok.Data;
import pl.prg.ba.entity.UserInfo;

import java.util.Optional;

@Data
public class CredentialsWrapper {
    private boolean success;
    private String message;
    private Integer id;

    public CredentialsWrapper(boolean success, String message, Integer id) {
        this.success = success;
        this.message = message;
        this.id = id;
    }
    public CredentialsWrapper(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.id = null;
    }
}
