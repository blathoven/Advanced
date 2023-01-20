package StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        String inputLine = scanner.nextLine();

        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) == '(') {
                indexes.push(i);
            } else if (inputLine.charAt(i) == ')') {
                int startIndex = indexes.pop();
                String currentSubExpression = inputLine.substring(startIndex, i + 1);
                System.out.println(currentSubExpression);
            }
        }
    }
}

