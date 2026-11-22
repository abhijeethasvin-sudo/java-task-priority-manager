import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    // The list stores tasks while the program is running.
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== TASK PRIORITY MANAGER ===");
            System.out.println("1. Add task");
            System.out.println("2. View tasks (highest priority first)");
            System.out.println("3. Complete task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextLine()) break;
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": addTask(); break;
                case "2": showTasks(); break;
                case "3": completeTask(); break;
                case "4": System.out.println("Goodbye!"); return;
                default: System.out.println("Please choose 1–4.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Task title: ");
        if (!scanner.hasNextLine()) return;
        String title = scanner.nextLine();
        System.out.print("Priority (1=high, 2=medium, 3=low): ");
        if (!scanner.hasNextLine()) return;
        String input = scanner.nextLine().trim();

        try {
            Task task = new Task(title, Integer.parseInt(input));
            tasks.add(task);
            System.out.println("Task added!");
        } catch (NumberFormatException error) {
            System.out.println("Enter a number from 1 to 3.");
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    // Make a sorted copy so tasks keep their original IDs in the main list.
    public static ArrayList<Task> sortedTasks(ArrayList<Task> input) {
        ArrayList<Task> result = new ArrayList<>(input);
        result.sort(Comparator.comparingInt(Task::getPriority));
        return result;
    }

    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        System.out.println("\nTasks (highest priority first):");
        for (Task task : sortedTasks(tasks)) {
            int id = tasks.indexOf(task) + 1;
            System.out.println(id + ". " + task);
        }
    }

    private static void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to complete.");
            return;
        }
        showTasks();
        System.out.print("Enter task number to complete: ");
        if (!scanner.hasNextLine()) return;
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (index < 0 || index >= tasks.size()) {
                System.out.println("That task number does not exist.");
                return;
            }
            tasks.get(index).markCompleted();
            System.out.println("Task completed!");
        } catch (NumberFormatException error) {
            System.out.println("Please enter a valid task number.");
        }
    }
}
