public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }
    public void markAsDONE(Task task){
        task.setStatus(TaskStatus.DONE);
    }
}
