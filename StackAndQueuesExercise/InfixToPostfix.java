package StackAndQueuesExercise.Memoization;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String currentElement = tokens[i];

            if (Character.isLetterOrDigit(currentElement.charAt(0))) {
                output.append(currentElement).append(" ");
                //Check if the operator is a digit.
            } else if (operatorStack.size() != 0 && (!currentElement.equals("(") && !currentElement.equals(")"))
                    && (!operatorStack.peek().equals("(") && !operatorStack.peek().equals(")"))) {
                //Check if there is an operator at the top of the stack which is not left parenthesis.

                int currentOperatorPrecedence = calculatePrecedence(currentElement);
                int lastOperatorPrecedence = calculatePrecedence(operatorStack.peek());

                if ((currentOperatorPrecedence <= lastOperatorPrecedence) &&
                        associativity(currentElement).equals("Left") && currentOperatorPrecedence != 0) {

                    output.append(operatorStack.pop()).append(" ");
                    operatorStack.push(currentElement);

                } else {
                    operatorStack.push(currentElement);
                }
                //Check if the current operator given equals "(".
            } else if (currentElement.equals("(")) {
                operatorStack.push(currentElement);
                //Check if the current operator given equals ")".
            } else if (currentElement.equals(")")) {

                while (true) {
                    assert operatorStack.peek() != null;
                    if (operatorStack.peek().equals("(")) {
                        operatorStack.pop();
                        break;
                    }
                    output.append(operatorStack.pop()).append(" ");
                }
            } else {
                operatorStack.push(currentElement);
            }
        }
        for (String remainingItems : operatorStack) {
            output.append(remainingItems).append(" ");
        }
        System.out.println(output);
    }

    public static int calculatePrecedence(String operator) {
        int precedence = 0;

        switch (operator) {
            case "^":
                precedence = 4;
                break;
            case "*":
            case "/":
                precedence = 3;
                break;
            case "+":
            case "-":
                precedence = 2;
                break;
            case "(":
            case ")":
                precedence = 1;
        }
        return precedence;
    }

    public static String associativity(String operator) {
        String associativity = "";

        switch (operator) {
            case "*":
            case "/":
            case "-":
            case "+":
                associativity = "Left";
                break;
            case "^":
                associativity = "Right";
        }
        return associativity;
    }
}
