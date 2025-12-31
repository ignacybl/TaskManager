import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService service;
    private TaskRepository<Task, UUID> repository;

    @BeforeEach
    void setUp(){
        repository = new TaskHashMapRepository();
        service = new TaskService(repository);
    }
    @Test
    void shouldAddTask(){
        service.addTask("Zadanie1", "Opis1", LocalDate.now());
        assertEquals(1, repository.getTasks().size());
    }
    @Test
    void shouldMakeTaskDone(){
        service.addTask("Zadanie1", "Opis1", LocalDate.now());
        service.markAsDONE("Zadanie1");
        Task task = repository.getTasks().iterator().next();
        assertEquals(TaskStatus.DONE, task.getStatus());
    }
    @Test
    void shouldRemoveTask(){
        service.addTask("Zadanie1", "Opis1", LocalDate.now());
        service.removeTask("Zadanie1");
        assertTrue(repository.getTasks().isEmpty());
    }
    @Test
    void shouldNotRemoveWhenNotFound(){
        service.addTask("Zadanie1", "Opis1", LocalDate.now());
        service.removeTask("Zadanie2");
        assertFalse(repository.getTasks().isEmpty());
    }

}