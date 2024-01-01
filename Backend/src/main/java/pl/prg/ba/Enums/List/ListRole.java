package pl.prg.ba.Enums.List;

public enum ListRole {
    OWNER("Owner"),
    VIEWER("Viewer"),
    EDITOR("Editor");
    private final String listRole;

    ListRole(String listRole) {
        this.listRole = listRole;
    }

    public String getListRole() {
        return listRole;
    }
//    public static ListRole fromString(String value) {
//        return switch (value.toLowerCase()) {
//            case "owner" -> OWNER;
//            case "viewer" -> VIEWER;
//            case "editor" -> EDITOR;
//            default -> throw new IllegalArgumentException("Unsupported list role: " + value);
//        };
//    }
}
