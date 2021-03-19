import java.io.*;

/**
 * The FileSaver class saves tasks right before the user quits the app and it helps to opens saved tasks.
 */
public class FileSaver {

    /**
     * This saves tasks to a file
     * @param taskList
     * @param name
     */
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

    /**
     * This opens a saved file from previous sessions.
     * @param name
     * @return
     */
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
