//Final Project for COCS 1436
//Arrays and ArrayLists

import java.io.*;
import java.util.*;

public class FinalProject {
  
  private static ArrayList<String> pendingTasks = new ArrayList<>();
  private static String[] completedTasks = new String[100];
  private static int completedIndex = 0;
  private static final String PENDING_FILE = "pendingTasks.txt";
  private static final String COMPLETED_FILE = "completedTasks.txt";
  
  public static void main(String[] args) {
    loadData();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("\nTask Manager Menu:");
      System.out.println("1. Add Task");
      System.out.println("2. Completed Task");
      System.out.println("3. View Tasks");
      System.out.println("4. Exit");
      int choice = getValidatedInt(scanner);

      Switch (choice) {
        case 1:
          addTask(scanner);
          break;
        case 2:
          completeTask(scanner);
          break;
        case 3:
          viewTasks();
          break;
        case 4:
          saveData();
          System.out.println("Exiting and saving data...");
          running = false;
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private static void addTask(Scanner scanner) {
    System.out.print("Enter task description: ");
    scanner.nextLine();
    String task = scanner.nextLine();
    pendingTasks.add(task);
    System.out.println("Task added.");
  }

private static void completeTask(Scanner scanner) {
  viewTasks();
  System.out.println("Enter index of task to complete: ");
  int index = getValidatedInt(scanner);

  try {
    String task = pendingTasks.remove(index);
    if (completedIndex < completedTasks.length) {
      completedTasks[completedIndex++] = task;
      System.out.println("Task marked as completed.");
    } else {
      System.out.println("Completed task list full!");
    }
  } catch (IndexOutOfBoundsException e) {
    System.out.println("Invalid index. No such task.");
  }
}

private static void viewTasks() {
  System.out.println("\nPending Tasks:");
  for (int i = 0; i < pendingTasks.size(); i++) {
    System.out.println(i + ". " + pendingTasks.get(i));
  }

  System.out.println("\nCompleted Tasks:");
  for (int i = 0; i < completedIndex; i++) {
    System.out.println(i + ". " + completedTasks.get[i]);
  }
}

private static int getValidatedInt(Scanner scanner) {
  System.out.print("Enter your choice: ");
  String input = scanner.next();
  try {
    return Integer.parseInt(input);
  } catch (NumberFormatException e) {
    System.out.println("Invalid input. Please enter a valid integer.");
    return getValidatedInt(scanner); //Recursive call
  }
}

private static void saveData() {
  try (BufferedWriter bw = newBufferedWriter(new FileWriter(PENDING_FILE))) {
    for (String task : pendingTasks) {
      bw.write(task);
      bw.newLine();
    }
  } catch (IOException e) {
    System.out.println("Error saving pending tasks: " + e.getMessage());
  }

  try (BufferedWriter bw = new BufferedWriter(new FileWriter(COMPLETED_FILE))) {
    for (int i = 0; i < completedIndex; i++) {
      bw.write(completedTasks[i]);
      bw.newLine();
    }
  } catch (IOException e) {
    System.our.println("Error saving completed tasks: " + e.getMessage());
  }
}

private static void loadData() {
  try (BufferedReader br = new BufferedReader(new FileReader(PENDING_FILE))) {
    String line;
    while ((line = br.readLine()) != null) {
      pendingTasks.add(line);
    }
  } catch (IOException e) {
    System.out.println("No pending tasks file found. Starting fresh.");
  }

  try(BufferedReader br = new BufferedReader(newFileReader(COMPLETED_FILE))) {
    String line;
    while ((line = br.readLine()) != null && completedIndex < completedTasks.length) {
      completedTasks[completedIndex++] = line;
    }
  } catch (IOException e) {
    System.out.println("No completed tasks file found. Starting fresh.");
  }
}
}  
