import java.io.Serializable;
import java.time.LocalDate;

/**
 * Tasks are created from Task class. Task class implements Serializable.
 * It is able to write and read objects to and from streams.
 */
public class Task implements Serializable {
    String title, project;
    LocalDate dueDate;
    boolean isDone;


    /**
     * In this construction function, each task will have:
     * @param title a title of the task
     * @param project a name of the project the task would belong to
     * @param dueDate a deadline for the task
     * and a status of the task (done/not done)
     */
    public Task (String title, String project, LocalDate dueDate) {
        this.title = title;
        this.project = project;
        this.dueDate = dueDate;
        this.isDone = false;
    }

    /**
     * @return Task title is returned as a string
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return Project name of the task is returned as a string
     */
    public String getProject() {
        return this.project;
    }

    /**
     * @return Task due date is returned as a local date
     */

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
     * @return Task completeness is returned as boolean
     */
    public boolean isDone() { return this.isDone();
    }

    /**
     * @param title Task title is set to a new
     */
    public void setTitle (String title) {
        this.title = title;
    }

    /**
     * Project name is set to a new
     * @param project
     */
    public void setProject (String project) {
        this.project = project;
    }

    /**
     * Task due date is set to a new
     * @param date
     */
    public void setDueDate (LocalDate date) {
        this.dueDate = date;
    }

    /**
     * Task is being marked as done
     */
    public void markDone() { this.isDone = true; }

    /**
     * @return Tasks made into a string
     */
    public String toString() {
        String s= " " + this.title + ", project: " + this.project + ", deadline: " + this.dueDate;
        return s;
    }
}
