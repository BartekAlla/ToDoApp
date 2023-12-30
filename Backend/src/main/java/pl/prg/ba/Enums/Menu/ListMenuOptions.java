package pl.prg.ba.Enums.Menu;

public enum ListMenuOptions {
    SHOW_LIST("Show list"),
    DELETE_LIST("Delete list"),
    BACK("Back");
    private final String listMenuOption;

    ListMenuOptions(String mainMenuOption) {
        this.listMenuOption = mainMenuOption;
    }

    public String getListMenuOption() {
        return listMenuOption;
    }
}
