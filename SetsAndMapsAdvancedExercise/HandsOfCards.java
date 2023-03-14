package SetsAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();

        Map<String, Set<String>> playerDecks = new LinkedHashMap<>();
        while (!commandLine.equals("JOKER")) {
            String[] tokens = commandLine.split(": ");

            String nameOfPlayer = tokens[0];
            String[] cards = tokens[1].split(", ");

            if (!playerDecks.containsKey(nameOfPlayer)) {
                playerDecks.put(nameOfPlayer, new HashSet<>());
            }

            for (String currentCard : cards) {
                playerDecks.get(nameOfPlayer).add(currentCard);
            }

            commandLine = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playerDecks.entrySet()) {
            String name = entry.getKey();
            Set<String> deck = entry.getValue();

            int totalPoints = 0;
            for (String currentCard : deck) {
                int powerInt = 0;

                StringBuilder power = new StringBuilder();
                for (int i = 0; i < currentCard.length() - 1; i++) {
                    power.append(currentCard.charAt(i));
                }
                if (Character.isDigit(power.charAt(0))) {
                    powerInt = Integer.parseInt(power.toString());
                } else {
                    switch (power.toString()) {
                        case "J":
                            powerInt = 11;
                            break;
                        case "Q":
                            powerInt = 12;
                            break;
                        case "K":
                            powerInt = 13;
                            break;
                        case "A":
                            powerInt = 14;
                    }
                }
                totalPoints += powerInt * getMultiplier(currentCard.charAt(currentCard.length() - 1));
            }
            System.out.printf("%s: %d\n", name, totalPoints);
        }
    }
    private static int getMultiplier(char multiplier) {
        int multiplierScore = 0;
        switch (multiplier) {
            case 'S':
                multiplierScore = 4;
                break;
            case 'H':
                multiplierScore = 3;
                break;
            case 'D':
                multiplierScore = 2;
                break;
            case 'C':
                multiplierScore = 1;
        }
        return multiplierScore;
    }
}
