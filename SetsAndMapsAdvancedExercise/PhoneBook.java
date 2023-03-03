package SetsAndMapsAdvancedExercise;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, String> contactList = new HashMap<>();
        while (!command.equals("search")) {
            String[] tokens = command.split("-");

            contactList.put(tokens[0], tokens[1]);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("stop")) {
            if (contactList.containsKey(command)) {
                System.out.printf("%s -> %s\n", command, contactList.get(command));
            } else {
                System.out.printf("Contact %s does not exist.\n", command);
            }

            command = scanner.nextLine();
        }
    }
}
