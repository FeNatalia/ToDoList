import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * This accepts an index and brings the task with that index from the list
     * @param index index is accepted
     * @return returns a task from task list by the index
     */

    public Task getTask (int index) {
        return this.tasks.get(index);
    }

    /**
     * This adds the given task to the list
     * @param task the task which is given
     * @return adds the task to task list
     */

    public boolean addTask (Task task) {
        return this.tasks.add(task);
    }

    /**
     * This removes the given task from the list
     * @param task the task which is given
     * @return removes the task from the task list
     */

    public boolean removeTask (Task task) {
        return this.tasks.remove(task);
    }

    /**
     * Can see if the task list empty
     */
    public boolean isEmpty () {
        return this.tasks.isEmpty();
    }

    /**
     * Gets available tasks in task list as a string
     * @return
     */
    public String getTasks() {
        String list ="";

        for (int i=0; i< this.tasks.size(); i++) {
            Task currentTask = this.tasks.get(i);
            list += (i+1) + currentTask.toString() + "\n";
        }
        return list;
    }

    /**
     * Stream helps to sort tasks by project name
      */
    public void sortByProject() {
        List<Task> list = this.tasks.stream()
            .sorted(Comparator.comparing(Task::getProject))
            .collect(Collectors.toList());
        this.tasks = new ArrayList<Task>(list);

    }

    /**
     * Collections.sort and Comparator help to sort tasks by date
     */
    public void sortByDate() {
        Collections.sort(this.tasks, new SortByDate());
    }

    static class SortByDate implements Comparator<Task> {
        @Override
        public int compare (Task a, Task b) {
            return a.getDueDate().compareTo(b.dueDate);
        }
    }



}
