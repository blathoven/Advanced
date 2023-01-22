package StackAndQueuesExercise;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.PreparedStatement;
import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandLines = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> textHistory = new ArrayDeque<>();
        StringBuilder finalText = new StringBuilder();

        for (int i = 0; i < commandLines; i++) {
            String[] currentCommand = scanner.nextLine().split("\\s+");

            switch (currentCommand[0]) {
                case "1":
                    finalText.append(currentCommand[1]);
                    textHistory.push(finalText.toString());
                    break;
                case "2":
                    String modifiedText = finalText.toString()
                            .substring(0, finalText.length() - Integer.parseInt(currentCommand[1]));
                    finalText = new StringBuilder();
                    finalText.append(modifiedText);
                    textHistory.push(finalText.toString());
                    break;
                case "3":
                    int indexRequired = Integer.parseInt(currentCommand[1]);
                    System.out.println(finalText.toString().charAt(indexRequired - 1));
                    break;
                case "4":
                    if (textHistory.size() > 1) {
                        textHistory.pop();
                        finalText = new StringBuilder(textHistory.peek());
                    } else {
                        finalText = new StringBuilder();
                    }
            }
        }
    }
}
