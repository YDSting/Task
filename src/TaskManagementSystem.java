import java.util.ArrayList;

class Task {
    String title;
    String description;
    private boolean completed;
    private String owner;

    public Task(String title, String description, String owner) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getOwner() {
        return owner;
    }

    public void markAsCompleted() {
        completed = true;
        System.out.println("Task '" + title + "' completed by " + owner);
    }
}

class User {
    private String name;
    private ArrayList<Task> tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void createTask(String title, String description) {
        Task task = new Task(title, description, name);
        tasks.add(task);
        System.out.println("Task '" + title + "' created by " + name);
    }

    public void editTask(Task task, String newTitle, String newDescription) {
        task.title = newTitle;
        task.description = newDescription;
        System.out.println("Task '" + task.getTitle() + "' edited by " + name);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
        System.out.println("Task '" + task.getTitle() + "' deleted by " + name);
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        user1.createTask("Complete Java Assignment", "Finish the coding exercises.");
        user2.createTask("Prepare for Meeting", "Gather information for the upcoming presentation.");

        Task task = user1.getTasks().get(0);
        user1.editTask(task, "Finish Java Assignment", "Revise and debug the code.");

        user2.deleteTask(user2.getTasks().get(0));

        System.out.println("Tasks assigned to " + user1.getName() + ": " + user1.getTasks().size());
        System.out.println("Tasks assigned to " + user2.getName() + ": " + user2.getTasks().size());
    }
}
