package pl.prg.ba.Enums.User;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getUserGender() {
        return gender;
    }
    public static Gender fromString(String value) {
        return switch (value.toLowerCase()) {
            case "male" -> MALE;
            case "female" -> FEMALE;
            default -> throw new IllegalArgumentException("Unsupported gender: " + value);
        };
    }
}
