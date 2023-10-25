package Assignments;

import java.util.Scanner;

public class CharacterFinder {
    public static char characterLocator(String inputString, String position) {
        try {
            int index = Integer.parseInt(position);
            if (index >= 0 && index < inputString.length()) {
                return inputString.charAt(index);
            } else {
                throw new StringIndexOutOfBoundsException();
            }
        } catch (NumberFormatException e) {
            return 'N';
        } catch (StringIndexOutOfBoundsException e) {
            return 'S';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        System.out.println("Enter the position:");
        String position = scanner.nextLine();

        char result = characterLocator(inputString, position);
        if (result == 'N') {
            System.out.println("NumberFormatException");
        } else if (result == 'S') {
            System.out.println("StringIndexOutOfBoundsException");
        } else {
            System.out.println("Character at the specified position: " + result);
        }

        scanner.close();
    }
}
