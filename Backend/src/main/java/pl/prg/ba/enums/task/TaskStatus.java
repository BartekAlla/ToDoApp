package pl.prg.ba.enums.task;

public enum TaskStatus {
    PENDING("Pending"),
    DONE("Done");
    private final String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
