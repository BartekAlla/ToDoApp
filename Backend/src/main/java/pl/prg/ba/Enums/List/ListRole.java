package pl.prg.ba.Enums.List;

public enum ListRole {
    OWNER("Owner"),
    VIEWER("Viewer"),
    EDITOR("Editor");
    private final String listRole;

    ListRole(String listRole) {
        this.listRole = listRole;
    }

}
