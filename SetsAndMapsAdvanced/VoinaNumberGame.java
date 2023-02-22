package SetsAndMapsAdvanced;
import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = fillPlayerNumbers(scanner);
        Set<Integer> secondPlayerCards = fillPlayerNumbers(scanner);

        for (int i = 0; i < 50; i++) {

            if (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {
                int firstPlayerValue = firstPlayerCards.iterator().next();
                firstPlayerCards.remove(firstPlayerValue);

                int secondPlayerValue = secondPlayerCards.iterator().next();
                secondPlayerCards.remove(secondPlayerValue);

                if (firstPlayerValue > secondPlayerValue) {
                    firstPlayerCards.add(firstPlayerValue);
                    firstPlayerCards.add(secondPlayerValue);
                } else if (secondPlayerValue > firstPlayerValue) {
                    secondPlayerCards.add(firstPlayerValue);
                    secondPlayerCards.add(secondPlayerValue);
                }
            } else {
                break;
            }
        }

        String output;

        if (firstPlayerCards.size() == secondPlayerCards.size()) {
            output = new String("Draw!");
        } else {
            output = firstPlayerCards.size() > secondPlayerCards.size() ? "First player win!" : "Second player win!";
        }

        System.out.println(output);
    }

    private static Set<Integer> fillPlayerNumbers(Scanner scanner) {
        int[] playerNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> playerUniqueNumbers = new LinkedHashSet<>();

        for (int currentNumber : playerNumbers) {
            playerUniqueNumbers.add(currentNumber);
        }
        return playerUniqueNumbers;
    }
}
