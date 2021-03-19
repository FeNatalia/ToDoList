import java.io.*;

public class FileSaver {
    public void saveTask(TaskList taskList, String name) {
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(taskList);
            output.close();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TaskList viewSavedTask(String name){
        TaskList taskList = new TaskList();
        try {
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream stream = new ObjectInputStream(file);
            taskList = (TaskList) stream.readObject();
            stream.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return taskList;
    }
}
