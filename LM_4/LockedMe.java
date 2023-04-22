package LM_4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LockedMe {
    static final String DIRECTORY_PATH = "D:\\Eclipse\\LockedMe\\Lockedmedirectory";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    addFile();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    searchFile1();
                    break;
                case 5:
                    System.out.println("Thank you for using the application, Application Closed");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 5);
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Application: Welcome to LockedMe.com - File Manager");
        System.out.println("Developed by: Vijay Bohara");
        System.out.println("--------------------------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1. Display all files");
        System.out.println("2. Add/Create a file");
        System.out.println("3. Delete a file");
        System.out.println("4. Search for a file");
        System.out.println("5. Close the application");
    }
    
    private static void displayAllFiles() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("List of all files in the directory:");
        ArrayList<String> fileList = getFilesInDirectory();
        if (fileList.isEmpty()) {
            System.out.println("The directory is empty.");
            return;
        }
        for (String file : fileList) {
            System.out.println(file);
        }
    }
    
    private static ArrayList<String> getFilesInDirectory() {
        File directory = new File(DIRECTORY_PATH);
        ArrayList<String> fileList = new ArrayList<>();
        if (directory.isDirectory()) {
            String[] files = directory.list();
            for (String file : files) {
                fileList.add(file);
            }
            Collections.sort(fileList);
        }
        return fileList;
    }
    
    private static void addFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------------------------------");
        System.out.println("Enter the name of the file to be added: ");
        String fileName = scanner.nextLine();
        File file = new File(DIRECTORY_PATH + "\\" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
    }
    
    private static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------------------------------");
        System.out.println("Enter the name of the file to be deleted: ");
        String fileName = scanner.nextLine();
        File file = new File(DIRECTORY_PATH + "\\" + fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File does not exist.");
        }
    }
    private static void searchFile1() {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file to search for: ");
        String fileName = scanner.nextLine();
        File folder = new File(DIRECTORY_PATH);
        File[] files = folder.listFiles();
        boolean found = false;
        for (File file : files) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                System.out.println("File found at location: " + file.getAbsolutePath());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("File not found.");
        }
    }

    
    private static void searchFile() {
        Scanner scanner = new Scanner(System.in);



}
    }