package SetsAndMapsAdvancedExercise;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        Map<Character, Integer> occurrences = new TreeMap<>();

        for (String s : input) {
            char currentChar = s.charAt(0);
            occurrences.putIfAbsent(currentChar, 0);
            occurrences.put(currentChar, occurrences.get(currentChar) + 1);
        }

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
