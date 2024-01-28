package pl.prg.ba.wrappers;

import lombok.Data;

@Data
public class CredentialsWrapper {
    private boolean success;
    private String message;

    public CredentialsWrapper(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
