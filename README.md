# ToDoList
ToDoList is a simple todo list app with a text-based user interface. 
You can add your tasks, see and maintain a list of your tasks. The app is controlled by commands written by the user in a terminal. 

## How to start
1. Clone this repository to your computer (open your Terminal and write git clone https://github.com/FeNatalia/ToDoListProject )
2. In your Terminal, go to src/main/java/ and compile the java files: Main, Menu, Task, TaskList ('javac Main.java' command via Terminal)
3. Run Main.java (via 'java Main.java' command)

## The app
After starting off, the app is ready to use. The main menu is self explained, but the detailed information you can find in the next paragraphs.

## The app instructions

The main menu has following options to choose from: 
(1) View Task List
(2) Add New Task
(3) Edit Task
(4) Save and Quit
(0) View finished tasks

You will be able to use functionality by typing one of the commands from 0 to 4.

### (1) View Task List

When you choose this option, you will be able to view task list sorted either by date or project name.
If the task list is empty, then the app will tell you that there is nothing to view yet. And with command (5) you will be returned to the main menu. 

### (2) Add New Task

When you choose this option, you will be asked to fill in a task name, project name (that the task will be associated with), and due date. When all steps are done, the app will tell you that it is saved. And with command (5) you will be returned to the main menu. 

### (3) Edit Task

When you choose this option, you will be able to edit an existing task. First, you will need to choose a task by writing the task number. Further, you will be asked to choose to edit either the task name, project name, due date or to mark the task as done or delete it. When one of these steps done, then the app will tell you that the changes are saved. And with command (5) you will be returned to the main menu. 

### (4) Save and Quit 

When you choose this option, all changes will be saved and the app will quit. The finished tasks will be save as "finishedTasks.txt", and the current task list will be saved as "myTasks.txt". 

### (0) View finished tasks 

When you choose this option, you will be able to view all previously finished task. And with command (5) you will be returned to the main menu. 



