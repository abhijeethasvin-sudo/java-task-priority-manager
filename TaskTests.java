import java.util.ArrayList;

public class TaskTests {
    private static int passed = 0;

    private static void check(boolean condition, String description) {
        if (!condition) throw new AssertionError("FAILED: " + description);
        System.out.println("PASS: " + description);
        passed++;
    }

    public static void main(String[] args) {
        Task homework = new Task("Study arrays", 2);
        check(homework.getTitle().equals("Study arrays"), "task title");
        check(homework.getPriority() == 2, "priority stored");
        check(!homework.isCompleted(), "new tasks start incomplete");
        homework.markCompleted();
        check(homework.isCompleted(), "mark task complete");

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Low", 3));
        tasks.add(new Task("High", 1));
        tasks.add(new Task("Medium", 2));
        ArrayList<Task> sorted = Main.sortedTasks(tasks);
        check(sorted.get(0).getTitle().equals("High") &&
              sorted.get(2).getTitle().equals("Low"), "sort by priority");
        check(tasks.get(0).getTitle().equals("Low"), "sorting keeps original IDs");

        boolean rejected = false;
        try { new Task("", 2); } catch (IllegalArgumentException e) { rejected = true; }
        check(rejected, "reject empty titles");
        rejected = false;
        try { new Task("Bad priority", 4); } catch (IllegalArgumentException e) { rejected = true; }
        check(rejected, "reject invalid priority");
        System.out.println("\n" + passed + " tests passed.");
    }
}
