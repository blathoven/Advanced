package SetsAndMapsAdvancedExercise;
import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfNumbers = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueNames = new LinkedHashSet<>();
        for (int i = 0; i < countOfNumbers; i++) {
            String currentName = scanner.nextLine();

            uniqueNames.add(currentName);
        }
        for (String currentName : uniqueNames) {
            System.out.println(currentName);
        }
    }
}
