package SetsAndMapsAdvancedExercise;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();

        Map<String, Map<String, Integer>> userData = new TreeMap<>();
        while (!commandLine.equals("end")) {
            String[] tokens = commandLine.split("\\s+");
            //1. IP    2. Message    3. Nickname

            String IP = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            if (!userData.containsKey(username)) {
                userData.put(username, new LinkedHashMap<>());
                userData.get(username).put(IP, 0);
            } else if (!userData.get(username).containsKey(IP)) {
                userData.get(username).put(IP, 0);
            }

            userData.get(username).put(IP, userData.get(username).get(IP) + 1);

            commandLine = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userData.entrySet()) {
            System.out.println(entry.getKey() + ":");

            Map<String, Integer> messagesCount = entry.getValue();

            int counter = 0;
            for (Map.Entry<String, Integer> values : messagesCount.entrySet()) {
                if (counter != 0) {
                    System.out.print(", ");
                }
                System.out.printf("%s => %d", values.getKey(), values.getValue());

                counter++;
                if (counter == messagesCount.size()) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
