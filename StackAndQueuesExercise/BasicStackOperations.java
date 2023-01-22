package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = inputLine[0]; //numbers of elements to push into the stack.
        int s = inputLine[1]; //numbers of elements to pop of the stack.
        int x = inputLine[2]; //the element, you should check if present into the stack.

        int[] numbersAssigned = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //pushing into the stack.
        Arrays.stream(numbersAssigned).limit(n).forEach(stack::push);

        //removing elements
        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        //checking if the element present

        if (isPresent(stack, x)){
            System.out.println("true");
        } else if (!stack.isEmpty()){
            System.out.println(smallestElement(stack));
        } else {
            System.out.println("0");
        }

    }
    public static boolean isPresent(ArrayDeque<Integer> stack, int x) {
        return stack.contains(x);
    }
    public static int smallestElement(ArrayDeque<Integer> stack) {
        int smallestValue = Integer.MAX_VALUE;

        for (int currentValue : stack) {
            if (currentValue < smallestValue) {
                smallestValue = currentValue;
            }
        }
        return smallestValue;
    }
}
