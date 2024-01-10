package pl.prg.ba.enums.user;

public enum UserRole {
    USER("User"),
    ADMIN("Admin");

    private final String userRole;

    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}
