package SetsAndMapsAdvancedExercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandLines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> userDuration = new TreeMap<>();
        Map<String, Set<String>> userIPsData = new TreeMap<>();
        for (int i = 0; i < commandLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String IP = tokens[0];
            String username = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            userDuration.putIfAbsent(username, 0);
            userDuration.put(username, userDuration.get(username) + duration);

            userIPsData.putIfAbsent(username, new TreeSet<>());
            userIPsData.get(username).add(IP);
        }

        userDuration.forEach((key, value) -> {
            System.out.printf("%s: %d[%s]\n", key, value, String.join(", ", userIPsData.get(key)));
        });
    }
}
