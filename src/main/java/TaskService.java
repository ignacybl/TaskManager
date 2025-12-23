import java.time.LocalDate;

public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }
    public void markAsDONE(String name){
        Task t = findTaskByTitle(name);
        if(t!=null){
            t.setStatus(TaskStatus.DONE);
        } else{
            System.out.println("Nie znaleziono zadania.");
        }
    }
    public void removeTask(String name){
        Task t = findTaskByTitle(name);
        if(t!=null){
            repository.remove(t.getId());
        } else {
            System.out.println("Nie znaleziono zadania.");
        }
    }
    public void addTask(String title, String description, LocalDate date){
        repository.add(new Task(title, description, date));
    }
    public void displayAll(){
        System.out.println("Wszystkie zadania: ");
        for(Task t : this.repository.getTasks()){
            System.out.println(t);
        }
    }
    public void displayByStatus(TaskStatus status){
        boolean isFound = false;
        for(Task t : repository.getTasks()) {
            if (t.getStatus() == status){
                isFound = true;
                System.out.println(t);
            }
        }
        if(!isFound) System.out.println("Nie znaleziono zadania o statusie: " + status);
    }
    private Task findTaskByTitle(String name){
        for(Task t : repository.getTasks()){
            if(t.getTitle().equalsIgnoreCase(name)){
                return t;
            }
        }
        return null;
    }

}
