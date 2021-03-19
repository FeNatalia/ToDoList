import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTitle() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        String expected = "feed my cat";
        assertEquals(expected, task.getTitle());
    }

    @Test
    void getProject() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        String expected = "pets";
        assertEquals(expected, task.getProject());
    }

    @Test
    void getDueDate() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        LocalDate expected = LocalDate.parse("2021-05-01");
        assertEquals(expected, task.getDueDate());
    }


    @Test
    void setTitle() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        task.setTitle("feed my cat");
        String expected = "feed my cat";
        assertEquals(expected, task.getTitle());
    }

    @Test
    void setProject() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        String expected = "pets";
        assertEquals(expected, task.getProject());
    }

    @Test
    void setDueDate() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        task.setDueDate(LocalDate.parse("2021-05-01"));
        LocalDate expected = LocalDate.parse("2021-05-01");
        assertEquals(expected, task.getDueDate());
    }

    @Test
    void markDone() {
        Task task = new Task ("feed my cat","pets", LocalDate.parse("2021-05-01"));
        task.markDone();
        assertEquals(true, task.isDone);
    }

}