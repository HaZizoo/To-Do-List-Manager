import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean completed;
    
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }
    
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    
    @Override
    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + description;
    }
}

public class TodoListManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;
    
    public TodoListManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addTask() {
        System.out.print("Enter task: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added!");
    }
    
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    
    public void markComplete() {
        viewTasks();
        System.out.print("Enter task number: ");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.get(num - 1).setCompleted(true);
            System.out.println("Task marked complete!");
        } else {
            System.out.println("Invalid number!");
        }
    }
    
    public void run() {
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Complete");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: markComplete(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void main(String[] args) {
        new TodoListManager().run();
    }
}
