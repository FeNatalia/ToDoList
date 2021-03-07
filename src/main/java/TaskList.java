import java.io.Serializable;
import java.util.ArrayList;

/**
 * TaskList class allows to keep a list of task.
 * Serialization allows to convert an Object to byte stream
 * and save it as file.
 */

public class TaskList implements Serializable {
    ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

}
