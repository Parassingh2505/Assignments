package Assignments;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CatalogSortedListSearch {
    private static List<String> catalogList = new ArrayList<>();

    public static String catalogListSearcher(String searchValue) {
        if (searchValue == null || searchValue.trim().isEmpty()) {
            return "Input is not accepted";
        }

        String sortedCatalog = catalogListSorter(catalogList);
        if (sortedCatalog.contains(searchValue)) {
            return "Found: " + searchValue;
        } else {
            return "Not Found";
        }
    }

    public static String catalogListSorter(List<String> catalogList) {
        if (catalogList == null || catalogList.isEmpty() || containsNullOrBlank(catalogList)) {
            return "The catalog List contains empty or null or blank space as a value";
        }

        Collections.sort(catalogList);
        return catalogList.toString();
    }

    private static boolean containsNullOrBlank(List<String> catalogList) {
        for (String item : catalogList) {
            if (item == null || item.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        catalogList.add("Nike");
        catalogList.add("Puma");
        catalogList.add("Adidas");
        catalogList.add("Reebok");
        catalogList.add("UnderArmour");
        catalogList.add("NBalance");
        catalogList.add("SuperDry");

        System.out.println("Sample Input: [Nike, Puma, Adidas, Reebok, UnderArmour, NBalance, SuperDry] AND Reebok");
        System.out.println("Expected Output: " + catalogListSearcher("Reebok"));
        System.out.println();

        System.out.println("Sample Input: [Nike, Puma, Adidas, Reebok, UnderArmour, NBalance, SuperDry] AND Lee");
        System.out.println("Expected Output: " + catalogListSearcher("Lee"));
        System.out.println();

        System.out.println("Sample Input: [Nike, Puma, Adidas, Reebok, UnderArmour, null, SuperDry] AND Lee");
        System.out.println("Expected Output: " + catalogListSearcher("Lee"));
        System.out.println();

        System.out.println("Sample Input: Null");
        System.out.println("Expected Output: " + catalogListSearcher(null));
        System.out.println();

        System.out.println("Sample Input: []");
        System.out.println("Expected Output: " + catalogListSorter(new ArrayList<>()));
        System.out.println();

        System.out.println("Sample Input: [Nike, Puma, Adidas, Reebok, UnderArmour, NBalance, SuperDry]");
        System.out.println("Expected Output: " + catalogListSorter(catalogList));
    }
}
