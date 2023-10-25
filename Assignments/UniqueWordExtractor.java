package Assignments;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueWordExtractor {

    public enum OrderType {
        ALPHABETIC_ASCENDING,
        ALPHABETIC_DESCENDING,
        LENGTH_THEN_ALPHABETIC_ASCENDING,
        INPUT_ORDER
    }

    public Set<String> extractUniqueWords(String paragraph, OrderType orderType) {
        // Split the paragraph into words using whitespace as a delimiter
        String[] words = paragraph.split("\\s+");

        // Create a set to store unique words
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        // Sort the unique words based on the specified order
        switch (orderType) {
            case ALPHABETIC_ASCENDING:
                uniqueWords = uniqueWords.stream()
                        .sorted()
                        .collect(Collectors.toCollection(LinkedHashSet::new));
                break;

            case ALPHABETIC_DESCENDING:
                uniqueWords = uniqueWords.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toCollection(LinkedHashSet::new));
                break;

            case LENGTH_THEN_ALPHABETIC_ASCENDING:
                uniqueWords = uniqueWords.stream()
                        .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                        .collect(Collectors.toCollection(LinkedHashSet::new));
                break;

            case INPUT_ORDER:
                // No sorting is needed for input order
                break;

            default:
                throw new IllegalArgumentException("Invalid order type");
        }

        return uniqueWords;
    }

    public static void main(String[] args) {
        String paragraph = "This is a sample paragraph containing some sample words. Sample words are used for this example.";

        UniqueWordExtractor extractor = new UniqueWordExtractor();

        Set<String> uniqueWordsAlphabeticAscending = extractor.extractUniqueWords(paragraph, OrderType.ALPHABETIC_ASCENDING);
        System.out.println("Alphabetic Ascending: " + uniqueWordsAlphabeticAscending);

        Set<String> uniqueWordsAlphabeticDescending = extractor.extractUniqueWords(paragraph, OrderType.ALPHABETIC_DESCENDING);
        System.out.println("Alphabetic Descending: " + uniqueWordsAlphabeticDescending);

        Set<String> uniqueWordsLengthThenAlphabeticAscending = extractor.extractUniqueWords(paragraph, OrderType.LENGTH_THEN_ALPHABETIC_ASCENDING);
        System.out.println("Length Then Alphabetic Ascending: " + uniqueWordsLengthThenAlphabeticAscending);

        Set<String> uniqueWordsInputOrder = extractor.extractUniqueWords(paragraph, OrderType.INPUT_ORDER);
        System.out.println("Input Order: " + uniqueWordsInputOrder);
    }
}


