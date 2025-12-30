import java.util.Collection;

public interface TaskRepository<T, ID> {
    void add(T task);
    void remove (ID id);
    Collection <T> getTasks();
    void readFromFile(String file);
}
