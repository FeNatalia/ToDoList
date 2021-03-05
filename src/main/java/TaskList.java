import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

}
