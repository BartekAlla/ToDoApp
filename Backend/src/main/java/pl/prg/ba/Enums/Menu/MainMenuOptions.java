package pl.prg.ba.Enums.Menu;

public enum MainMenuOptions {
    SIGN_IN("Sign in"),
    SIGN_UP("Sign up"),
    SHOW_ALL_USERS("Show all users"),
    SHOW_ALL_LISTS("Show all lists"),
    EXIT("Exit");

    private final String mainMenuOption;

    MainMenuOptions(String mainMenuOption) {
        this.mainMenuOption = mainMenuOption;
    }

    public String getMainMenuOption() {
        return mainMenuOption;
    }
}
