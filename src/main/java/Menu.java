import java.util.Scanner;

public class Menu {

    TaskList taskList;
    Scanner scanner;

    public Menu(){
        this.taskList = new TaskList();
    }

    public void start() {
        printIntro();
        printOptions();
    }


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
