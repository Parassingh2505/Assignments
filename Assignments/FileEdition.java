package Assignments;

import java.io.*;
import java.util.Scanner;

public class FileEdition {
    public static String fileEditor(String fileName, String content) {
        if (fileName == null || fileName.trim().isEmpty() || content == null || content.trim().isEmpty()) {
            return "Invalid Input";
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(content);
            return "Hi my name is " + content;
        } catch (FileNotFoundException e) {
            return "File '" + fileName + "' not Found";
        } catch (IOException e) {
            return "Error occurred while writing to the file";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a file name:");
        String fileName = scanner.nextLine();

        System.out.println("Enter content to append:");
        String content = scanner.nextLine();

        String result = fileEditor(fileName, content);
        System.out.println("Expected Output: " + result);

        scanner.close();
    }
}
