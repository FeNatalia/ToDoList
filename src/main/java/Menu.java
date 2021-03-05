import java.util.Scanner;

/**
 * Menu class provides a text based user interface
 * controlled via command-line by the user
 */

public class Menu {

    TaskList taskList;
    Scanner scanner;

    public Menu(){
        this.taskList = new TaskList();
    }

    /**
     * Menu's start method which prints welcoming intro of the app
     * and prints action options
     */
    public void start() {
        printIntro();
        printOptions();
    }

    /**
     * The app prints action options in the main menu
     */
    private void printIntro() {
        System.out.println("__________________________________________________\n" +
                "Hi there,\n" +
                "\n" +
                "Todo-list App is here to help you with your tasks! \n"+
                "__________________________________________________\n"+

                "Please choose an option:\n");
    }

    /**
     * The app prints options
     */
    private void printOptions() {
        System.out.println("(1) View Task List\n" +
                "(2) Add New Task\n" +
                "(3) Edit Task\n" +
                "(4) Save and Quit\n");
    }

}
