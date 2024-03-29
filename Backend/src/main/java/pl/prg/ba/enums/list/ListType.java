package pl.prg.ba.enums.list;

public enum ListType {
    PUBLIC("Public"),
    PRIVATE("Private");
    private final String listType;

    ListType(String listType) {
        this.listType = listType;
    }

    public String getListType() {
        return listType;
    }
    public static ListType fromString(String value) {
        return switch (value.toLowerCase()) {
            case "public" -> PUBLIC;
            case "private" -> PRIVATE;
            default -> throw new IllegalArgumentException("Unsupported list type: " + value);
        };
    }
}
