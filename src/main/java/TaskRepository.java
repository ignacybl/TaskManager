import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskRepository {
    private Map <UUID, Task> tasks = new HashMap<>();

    public void add(Task task){
        this.tasks.put(task.getId(), task);
    }

    public void remove(UUID id){
        this.tasks.remove(id);
    }
    public Collection<Task> getTasks(){
        return tasks.values();
    }

    public void displayAll(){
        System.out.println("Wszystkie zadania: ");
        for(Task t : tasks.values()){
            System.out.println(t);
        }
    }
}
