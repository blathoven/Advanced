package SetsAndMapsAdvancedExercise;
import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();

        Map<String, String> users = new LinkedHashMap<>();
        while (!commandLine.equals("stop")) {
            String email = scanner.nextLine().toLowerCase(Locale.ROOT);

            if (!email.endsWith("com")&& !email.endsWith("uk") && !email.endsWith("us")) {
                users.put(commandLine, email);
            }
            commandLine = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}
