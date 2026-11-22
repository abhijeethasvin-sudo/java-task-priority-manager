public class Task {
    private final String title;
    private final int priority; // 1 is highest, 3 is lowest
    private boolean completed;

    public Task(String title, int priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty.");
        }
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException("Priority must be 1, 2, or 3.");
        }
        this.title = title.trim();
        this.priority = priority;
        this.completed = false;
    }

    public String getTitle() { return title; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { completed = true; }

    public String toString() {
        String status = completed ? "Done" : "To do";
        return title + " | Priority " + priority + " | " + status;
    }
}
