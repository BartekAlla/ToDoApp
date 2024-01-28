package pl.prg.ba.wrappers;

import lombok.Data;

@Data
public class SignUpResponseWrapper {
    private boolean success;
    private String message;

    public SignUpResponseWrapper(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
