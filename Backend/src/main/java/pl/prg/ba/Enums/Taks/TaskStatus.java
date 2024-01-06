package pl.prg.ba.Enums.Taks;

public enum TaskStatus {
    PENDING("Pending"),
    DONE("Done");
    private final String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
