package Assignments;

import java.util.Scanner;

public class WrapperClassConvert {
    public static Object convertToWrapper(Object object) {
        if (object == null) {
            return "Give proper primitive type as input";
        }

        if (object instanceof Integer) {
            return Integer.valueOf((int) object);
        } else if (object instanceof Double) {
            return Double.valueOf((double) object);
        } else if (object instanceof Float) {
            return Float.valueOf((float) object);
        } else if (object instanceof Character) {
            return Character.valueOf((char) object);
        } else if (object instanceof Boolean) {
            return Boolean.valueOf((boolean) object);
        } else if (object instanceof Short) {
            return Short.valueOf((short) object);
        } else if (object instanceof Byte) {
            return Byte.valueOf((byte) object);
        } else if (object instanceof Long) {
            return Long.valueOf((long) object);
        } else {
            return "Give proper primitive type as input";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a value of primitive type:");
        Object inputValue;

        if (scanner.hasNextInt()) {
            inputValue = scanner.nextInt();
        } else if (scanner.hasNextDouble()) {
            inputValue = scanner.nextDouble();
        } else if (scanner.hasNextFloat()) {
            inputValue = scanner.nextFloat();
        } else if (scanner.hasNextBoolean()) {
            inputValue = scanner.nextBoolean();
        } else if (scanner.hasNextShort()) {
            inputValue = scanner.nextShort();
        } else if (scanner.hasNextByte()) {
            inputValue = scanner.nextByte();
        } else if (scanner.hasNextLong()) {
            inputValue = scanner.nextLong();
        } else {
            inputValue = scanner.next();
        }

        Object result = convertToWrapper(inputValue);

        System.out.println("Expected Output: " + result);

        scanner.close();
    }
}
