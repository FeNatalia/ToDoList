import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    String title, project;
    LocalDate dueDate;
    boolean done;


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
        this.done = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getProject() {
        return this.project;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public boolean done() {
        return this.done;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setProject (String project) {
        this.project = project;
    }

    public void markDone() {
        this.done = true;
    }

    public String toString() {
        String s= this.title + ", project:" + this.project + ", deadline: " + this.dueDate;
        return s;
    }



}
