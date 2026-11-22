# Task Priority Manager (Java)

A beginner-friendly Java command-line application for organizing tasks by priority. Built to practice object-oriented programming, collections, sorting, user input, and testing.

## Features

- Add a task with a title and priority: **1 = high**, **2 = medium**, **3 = low**
- Display tasks sorted by priority (highest first)
- Mark a task as completed using its displayed number
- Validate empty task titles, invalid priorities, and invalid task numbers
- Run eight dependency-free automated checks

## Technology and design

- **Java:** JDK 11 or newer; no external packages required
- **`Task.java`:** Stores one task and its completed state, with validation in its constructor
- **`Main.java`:** Terminal menu, list of tasks, and sorting logic
- **`TaskTests.java`:** Small test runner using explicit assertions (no JUnit setup required)

An `ArrayList<Task>` stores tasks in memory. `sortedTasks()` creates a **copy** before sorting to keep task numbers stable when marking a task complete. `Comparator.comparingInt` orders priorities from 1 to 3.

## Run in VS Code

1. Install a JDK and the **Extension Pack for Java** in VS Code.
2. Open this folder in VS Code and open **Terminal → New Terminal**.
3. Verify `java -version` and `javac -version`.
4. Compile and run:

   ```bash
   javac Task.java Main.java TaskTests.java
   java Main
   ```

5. Test the project:

   ```bash
   java TaskTests
   ```

Expected test output ends with `8 tests passed.`

## Example

```text
=== TASK PRIORITY MANAGER ===
1. Add task
2. View tasks (highest priority first)
3. Complete task
4. Exit
Choose an option: 1
Task title: Practice Python
Priority (1=high, 2=medium, 3=low): 1
Task added!
```

## Project structure

```text
java-task-priority-manager/
├── Main.java          # Menu, input, sorting
├── Task.java          # Task model and validation
├── TaskTests.java     # Eight automated checks
├── README.md          # Documentation
└── .gitignore         # Exclude compiled files
```

## Limitations and next steps

- Tasks are stored **only while the program runs**; they are not saved when it exits.
- For larger projects, add file persistence, edit/delete functions, due dates, and JUnit tests.

## What I learned / interview discussion

- When would a class be better than storing tasks as plain strings?
- Why does the sort create a copy instead of changing the original list?
- How are invalid inputs handled?
- How would I save tasks between sessions?

> If you used AI or tutorials, review the code, explain each function in your own words, and make a personal improvement before presenting this as your own work.
