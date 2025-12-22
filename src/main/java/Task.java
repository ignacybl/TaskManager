import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDate date;
    private TaskStatus status;

    public Task(String title, String description, LocalDate date) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = TaskStatus.TODO;
        validate(title, description, date);
    }
    public UUID getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public void setStatus(TaskStatus status){
        this.status = status;
    }
    public TaskStatus getStatus(){
        return status;
    }
    private void validate(String title, String description, LocalDate date){
        TextFieldValidator validator = new TextFieldValidator();
        DateValidator dateValidator = new DateValidator();
        dateValidator.validate(date);
        validator.validate(title);
        validator.validate(description);
    }

    @Override
    public String toString() {
        return "[" + status + "] " + title + "\n" + "Opis: " + description + "\n" +
                "Termin: " + date + "\n" + "ID: " + this.id + "\n" +
                "---------------------------";
    }
}
