import java.util.List;
import java.util.ArrayList;

public class TaskList {
    
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(String description) {
        List<Task> toBeRemoved = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                toBeRemoved.add(t);
            }
        }
        tasks.removeAll(toBeRemoved);
    }

    public int getTasksCount() {
        return tasks.size();
    }

    public List<Task> getTasksDescriptions() {
        return tasks;
    }
}
