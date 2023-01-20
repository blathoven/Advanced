package StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        String[] inputLine = scanner.nextLine().split("\\s+");
        stack.push(Integer.parseInt(inputLine[0]));

        for (int i = 1; i < inputLine.length; i+= 2) {
            String operator = inputLine[i];
            int currentValue = Integer.parseInt(inputLine[i + 1]);
            int result = stack.pop();

            if (operator.equals("-")) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
                stack.push(result);
        }
        System.out.println(stack.peek());
    }
}


//    ArrayDeque<Integer> digits = new ArrayDeque<Integer>();
//
//    StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < inputLine.length; i++) {
//        String currentValue = inputLine[i];
//
//        if (currentValue.equals("-")) {
//        sb.append("-");
//        } else if (Character.isDigit(currentValue.charAt(0))) {
//        sb.append(currentValue);
//        digits.add(Integer.parseInt(sb.toString()));
//        sb = new StringBuilder();
//        }
//        }
//        int sum = 0;
//
//        for (int currentElement : digits) {
//        sum = sum + (currentElement);
//        }
//        System.out.println(sum);