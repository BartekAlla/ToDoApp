package pl.prg.ba.enums.list;

public enum ListRole {
    OWNER("Owner"),
    VIEWER("Viewer"),
    EDITOR("Editor");
    private final String listRole;

    ListRole(String listRole) {
        this.listRole = listRole;
    }

}
