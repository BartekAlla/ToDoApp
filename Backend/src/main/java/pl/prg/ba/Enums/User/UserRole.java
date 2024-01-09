package pl.prg.ba.Enums.User;

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
