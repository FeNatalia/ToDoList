import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Menu class provides a text based user interface
 * controlled via command-line by the user of the app
 */

public class Menu {

    FileSaver fileSaver;
    TaskList taskList;
    Scanner scanner;
    TaskList completedTasks;

    public Menu(){

        this.fileSaver= new FileSaver();
        this.taskList = new TaskList();
        this.scanner = new Scanner(System.in);
        this.completedTasks = new TaskList();
    }

    /**
     * Menu's start method which prints welcoming intro of the app
     * and prints action options
     */
    public void start() {
        this.taskList= fileSaver.viewSavedTask("myTasks.txt");
        this.completedTasks = fileSaver.viewSavedTask("finishedTasks.txt");
        printIntro();
        printOptions();
        acceptOption();
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
                "(4) Save and Quit\n"+
                "(0) View finished tasks\n");
    }

    /**
     * The app accepts an option
     */
    private void acceptOption() {
        boolean finished = false;
        while (!finished) {
            System.out.println("Type 5 for going back to the menu:");
            try {
                int option = Integer.valueOf(scanner.nextLine());
                finished = executeOption(option);
            }
            catch(IllegalArgumentException e) {
                printWrongOptionWarning();
            }
        }
    }

    /**
     * The app executes the command given by the user
     * if invalid command then it prints a warning message
     * @param option
     * @return
     */
    public boolean executeOption (int option){
        boolean quit = false;
        switch (option) {
            case 5:
                printOptions();
                break;
            case 1:
                viewTaskList(this.taskList);
                break;
            case 2:
                addTask();
                break;
            case 3:
                editTask();
                break;
            case 4:
                saveTask();
                quit = true;
                break;
            case 0:
                viewTaskList(this.completedTasks);
                break;
            default:
                printWrongOptionWarning();
                break;
        }
        return quit;
    }

    /**
     * Shows sorting options
     * @param list
     */
    public void viewTaskList (TaskList list) {
        if (list.isEmpty()) {
            System.out.println("No tasks yet, you can go back to Main Menu and add your tasks.");
        } else {
            sortTaskList(list);
            System.out.println(list.getTasks());
        }
    }

    /**
     * Sorts and shows the task list in order chosen by user
     * @param list
     */
    public void sortTaskList (TaskList list) {
        boolean correctCommand = false;

        while (!correctCommand) {
            System.out.println("View Task List sorted by: \n" +
                    "(1) project name or \n" +
                    "(2) due date?\n" +
                    "Type 0 to go back to Main Menu");
            try {
                int command = Integer.valueOf(scanner.nextLine());
                switch (command) {
                    case 0:
                        printOptions();
                        acceptOption();
                        break;
                    case 1:
                        taskList.sortByProject();
                        correctCommand = true;
                        break;
                    case 2:
                        taskList.sortByDate();
                        correctCommand = true;
                        break;
                    default:
                        printWrongOptionWarning();
                }
            }
            catch (IllegalArgumentException e) {
                printWrongOptionWarning();
            }
        }
    }
    /**
     * The app creates a task based on the data provided by the user
     */
    public void addTask() {
        String title = getTaskTitle();
        String project = getProjectName();
        LocalDate dueDate = getDueDate();

        Task task = new Task (title, project, dueDate);

        if (this.taskList.addTask(task)) {
            System.out.println("Your task \"" + title+ "\" is assigned to project \""
                    + project + "\" with the due date on "+ dueDate.toString());
        }
    }

    /**
     * The app asks user to provide the task's title
     * @return
     */
    private String getTaskTitle() {
        String title="";

        System.out.println("Type your task's title:");
        title = scanner.nextLine();
        return title;
    }
    /**
     * The app asks user to provide the project's name
     * that the task would belong to
     * @return
     */
    private String getProjectName() {
        String project ="";
        System.out.println("Type a project name your task would belong to:");
        project = scanner.nextLine();
        return project;
    }
    /**
     * The app asks user to provide the task's deadline in LocalDate format
     * @return
     */
    public LocalDate getDueDate() {
        LocalDate dueDate = null;

        while (dueDate == null) {
            System.out.println("When the task should get done?\n" +
                    "Please type in the following format: yyyy-mm-dd:");
            try {
                LocalDate date = LocalDate.parse(scanner.nextLine());
                LocalDate today = LocalDate.now();
                if (date.compareTo(today) == -1) {
                    System.out.println("You cannot choose the date which has passed already");
                } else {
                    dueDate = date;
                }
            }

            catch (DateTimeParseException e) {
                printWrongFormatWarning();
            }
        }
        return dueDate;
    }
    /**
     * This prints a wrong command warning message
     */
    public void printWrongOptionWarning() {
        System.out.println("Incorrect command, try another\n");
    }
    /**
     * This prints a wrong date format warning message
     */
    private void printWrongFormatWarning() {
        System.out.println("Incorrect format, please follow this format: yyyy-mm-dd");
    }
    public void saveTask() {
        fileSaver.saveTask(this.taskList, "myTasks.txt");
        fileSaver.saveTask(this.completedTasks, "finishedTasks.txt");
    }

    public void editTask(){
        if (this.taskList.isEmpty()) {
            System.out.println("You don't have any saved tasks in your list to edit.");
            return;
        }
        int taskNum = pickTaskToEdit();
        Task pickedTask = this.taskList.getTask(taskNum);

        executeEditOption(pickedTask, taskNum);
    }

    public int pickTaskToEdit(){
        while (true) {
            System.out.println("Pick the task that you would like to edit:\n");
            System.out.println(this.taskList.getTasks());

            try {
                int taskNum;
                taskNum = Integer.valueOf(scanner.nextLine()) - 1;
                this.taskList.getTask(taskNum);
                return taskNum;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nPlease pick one existing task to edit\n");
            } catch (IllegalArgumentException e) {
                System.out.println("\nPlease pick one existing task to edit\n");
            }
        }
    }

    public void executeEditOption(Task pickedTask, int taskNum) {
        boolean correctOption = false;
        while (!correctOption) {
            System.out.println("What would you like to edit?\n" +
                    "(1) Task name\n" +
                    "(2) Task project name\n" +
                    "(3) Task deadline\n" +
                    "OR you can as well:\n" +
                    "(4) Mark Task as done\n" +
                    "(5) Delete Task\n" +
                    "(0) Go back to the main menu");
            try {
                int execute = Integer.valueOf(scanner.nextLine());

                switch (execute) {
                    case 1:
                        String newTitle = getTaskTitle();
                        pickedTask.setTitle(newTitle);
                        System.out.println("The task name is edited to \'" + newTitle + "' now.\n");
                        correctOption = true;
                        break;
                    case 2:
                        String newProjectName = getProjectName();
                        pickedTask.setProject(newProjectName);
                        System.out.println("The project name is edited to \'" + newProjectName + "' now.\n");
                        correctOption = true;
                        break;
                    case 3:
                        LocalDate newDate = getDueDate();
                        pickedTask.setDueDate(newDate);
                        correctOption = true;
                        break;
                    case 4:
                        pickedTask.markDone();
                        if (this.taskList.removeTask(pickedTask) && this.taskList.addTask(pickedTask)) {
                            System.out.println("The task is marked as done now and is transferred into completed task list \n" +
                                    "which is available in the main menu");
                            correctOption = true;
                        } else {
                            printWrongOptionWarning();
                        }
                        break;
                    case 5:
                        if (this.taskList.removeTask(pickedTask)) {
                            System.out.println("The task is removed from your list now\n");
                        } else {
                            printWrongOptionWarning();
                        }
                        correctOption = true;
                        break;
                    case 0:
                        printOptions();
                        acceptOption();
                    default:
                        printWrongOptionWarning();
                }
            } catch (IllegalArgumentException e) {
                printWrongOptionWarning();
            }

        }
    }



}
