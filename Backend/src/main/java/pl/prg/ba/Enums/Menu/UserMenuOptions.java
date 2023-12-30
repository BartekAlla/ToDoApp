package pl.prg.ba.Enums.Menu;

public enum UserMenuOptions {
    SHOW_LISTS("Show lists"),
    ADD_LIST("Add list"),
    ABOUT_ME("About me"),
    LOGOUT("Logout");

    private final String userMenuOption;

    UserMenuOptions(String userMenuOption) {
        this.userMenuOption = userMenuOption;
    }

    public String getUserMenuOption() {
        return userMenuOption;
    }
}
