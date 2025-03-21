public class App {
    public static void main(String[] args) throws Exception {
        
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        taskList.addTask("Task 1");
        taskList.addTask("Task 3");
        System.out.println("Tasks count: "+ taskList.getTasksCount());        
        taskList.removeTask("Task 1");
        System.out.println("Tasks count: "+ taskList.getTasksCount());
    }
}
