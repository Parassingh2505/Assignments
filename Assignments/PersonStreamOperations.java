package Assignments;

import java.util.*;
import java.util.stream.Collectors;

public class PersonStreamOperations {

    public Optional<List<String>> getPersonListSortedByNameInUpperCase(List<String> personList) {
        if (personList == null || personList.isEmpty()) {
            return Optional.empty();
        }
        List<String> sortedList = personList.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        return Optional.of(sortedList);
    }

    public Set<String> getDistinctPersonNamesSortedInDescendingOrder(List<String> personList) {
        if (personList == null || personList.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> distinctSortedNames = personList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toSet());
        return distinctSortedNames;
    }

    public boolean searchPerson(List<String> personList, String nameToSearch) {
        if (personList == null || nameToSearch == null || nameToSearch.isEmpty()) {
            System.out.println("List or name to search cannot be null");
            return false;
        }
        boolean personFound = personList.stream()
                .anyMatch(name -> name.equalsIgnoreCase(nameToSearch));
        if (personFound) {
            System.out.println("Person found");
        } else {
            System.out.println("Person not found");
        }
        return personFound;
    }

    public List<String> getPersonListSortedByLengthWithNameLengthGreaterThanFive(List<String> personList) {
        if (personList == null || personList.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> filteredAndSortedNames = personList.stream()
                .filter(name -> name.length() > 5)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        return filteredAndSortedNames;
    }

    public String getPersonByMaxAge(Map<String, Integer> personMap) {
        if (personMap == null || personMap.isEmpty()) {
            return "Give proper input not null";
        }
        Map.Entry<String, Integer> maxEntry = Collections.max(personMap.entrySet(), Map.Entry.comparingByValue());
        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        PersonStreamOperations operations = new PersonStreamOperations();

        List<String> personList = Arrays.asList("Kamala", "Priyanka", "Gautham", "Moses");
        Optional<List<String>> sortedNames = operations.getPersonListSortedByNameInUpperCase(personList);
        System.out.println("Sorted Names: " + sortedNames.orElse(Collections.emptyList()));

        List<String> duplicateNamesList = Arrays.asList("Kamala", "Priyanka", "Moses", "Kamala", "Gautham");
        Set<String> distinctSortedNames = operations.getDistinctPersonNamesSortedInDescendingOrder(duplicateNamesList);
        System.out.println("Distinct Sorted Names: " + distinctSortedNames);

        String nameToSearch = "Gautham";
        operations.searchPerson(personList, nameToSearch);

        List<String> longNamesList = Arrays.asList("Kamala", "Priyanka", "Gautham", "Moses", "Latha", "Punith");
        List<String> filteredAndSortedNames = operations.getPersonListSortedByLengthWithNameLengthGreaterThanFive(longNamesList);
        System.out.println("Filtered and Sorted Names: " + filteredAndSortedNames);

        Map<String, Integer> personMap = new HashMap<>();
        personMap.put("Gautham", 30);
        personMap.put("Latha", 56);
        personMap.put("Punith", 45);
        personMap.put("Kamala", 40);
        String personWithMaxAge = operations.getPersonByMaxAge(personMap);
        System.out.println("Person with Maximum Age: " + personWithMaxAge);
    }
}
