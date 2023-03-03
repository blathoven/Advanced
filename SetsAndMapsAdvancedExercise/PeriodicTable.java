package SetsAndMapsAdvancedExercise;
import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chemicalsCounts = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueChemicals = new TreeSet<>();
        for (int i = 0; i < chemicalsCounts; i++) {
            String[] currentChemicals = scanner.nextLine().split("\\s+");

            uniqueChemicals.addAll(Arrays.asList(currentChemicals));
        }
        uniqueChemicals.forEach(e -> System.out.print(e + " "));
    }
}
