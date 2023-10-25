package Assignments;

import java.util.ArrayList;
import java.util.List;

public class FruitsListService {

    public static List<String> addFruitsToList(String fruitsInput) {
        String[] fruitsArray = fruitsInput.split(",");
        List<String> fruitList = new ArrayList<>();

        for (String fruit : fruitsArray) {
            String trimmedFruit = fruit.trim().toLowerCase();
            if (!fruitList.contains(trimmedFruit)) {
                fruitList.add(trimmedFruit);
            }
        }

        return fruitList;
    }

    public static int searchFruitInList(List<String> fruitList, String fruitToSearch) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).equals(fruitToSearch)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchFruitInListIgnoreCase(List<String> fruitList, String fruitToSearch) {
        String fruitToSearchLowercase = fruitToSearch.toLowerCase();
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).equals(fruitToSearchLowercase)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test the methods
        String fruitsInput = "apple, mango, Cherry";
        List<String> fruitList = addFruitsToList(fruitsInput);
        System.out.println("Fruit List: " + fruitList);

        String searchFruit = "Mango";
        int index = searchFruitInList(fruitList, searchFruit);
        System.out.println("Index of " + searchFruit + " (case-sensitive search): " + index);

        int indexIgnoreCase = searchFruitInListIgnoreCase(fruitList, searchFruit);
        System.out.println("Index of " + searchFruit + " (case-insensitive search): " + indexIgnoreCase);
    }
}
