import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

public class TaskHashMapRepository implements TaskRepository<Task, UUID> {
    private Map <UUID, Task> tasks = new HashMap<>();
    @Override
    public void add(Task task){
        this.tasks.put(task.getId(), task);
    }
    @Override
    public void remove(UUID id){
        this.tasks.remove(id);
    }
    @Override
    public Collection<Task> getTasks(){
        return tasks.values();
    }
    @Override
    public void readFromFile(String file){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try(Scanner fileReader = new Scanner(Paths.get(file))){
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String [] parts = line.split("[/,]");
                String title = parts[0];
                String description = parts[1];
                LocalDate date = LocalDate.parse(parts[2], formatter);
                add(new Task(title, description, date));
            }
        }
        catch(Exception e){
            System.out.println("The file cannot be read");
        }
    }
}
