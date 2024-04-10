import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Task> tasks = new ArrayList();

    public static void main(String[] args) {
        String[] events = new String[]{"(1) Add a Task", "(2) Remove a Task", "(3) Update Task", "(4) List tasks", "(5) List Tasks by Priority", "(6) Quit"};

        String taskSelect = "";


        while (!taskSelect.equals("6")) {
            for(String event : events) {
                System.out.println(event);
            }

            System.out.println("What do you wanna do?");
            taskSelect = input.nextLine();
            if (taskSelect.equals("1")) {
                addTasks();
            }

            if (taskSelect.equals("2")) {
                removeTasks();
            }

            if (taskSelect.equals("3")) {
                updateTasks();
            }

            if (taskSelect.equals("4")) {
                listTasks();
            }
            if (taskSelect.equals("5")) {
                taskByPriority();
            }
        }

    }

    static void addTasks() {

        System.out.println("What's the title?");
        String taskTitle = input.nextLine();

        System.out.println("What's the tasks description?");
        String taskDesc = input.nextLine();

        System.out.println("What is the tasks priority?");
        int taskPriority = input.nextInt();
        input.nextLine();

        Task newTask = new Task(taskTitle, taskDesc, taskPriority);
        tasks.add(newTask);


    }

    static void removeTasks() {

        System.out.println("What task would you like to remove...");
        System.out.println(tasks);
        int removeTask = input.nextInt();
        input.nextLine();
        tasks.remove(removeTask);
    }

    static void updateTasks() {
        System.out.println("What do you want to update?");
        System.out.println(tasks);
        System.out.println("Update a task...");
        input.nextLine();
    }

    static void listTasks() {
        String taskSelector = "";
        String individualTask = "";

        System.out.println("Would you like to list one task or all tasks? (1, 2)");
        taskSelector = input.nextLine();
        if (taskSelector.equals("1")) {
            System.out.println("Which task to list? (Use Numbers)");
            individualTask = input.nextLine();
            System.out.println(tasks.get(Integer.parseInt(individualTask)));
        } else if (taskSelector.equals("2")) {

            //Project 3
            //You have go from list tasks -> 2 | automatically lists them sorted

            Collections.sort(tasks);
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("Not a Valid Option");
        }
    }

    static void taskByPriority() {
        try {
            System.out.println("Which priority would you like to list?");
            int priority = input.nextInt();
            input.nextLine();

            for (Task task : tasks) {
                if (task.getTaskPriority() == priority) {
                    System.out.println(task);
                }
            }
        } catch (Exception e) {
            System.out.println("Not a Valid Number");
        }
    }
}

