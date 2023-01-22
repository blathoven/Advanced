package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = inputLine[0]; //numbers of elements to push into the queue.
        int s = inputLine[1]; //numbers of elements to pop of the queue.
        int x = inputLine[2]; //the element, you should check if present into the queue.

        int[] numbersAssigned = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //pushing into the queue.
        Arrays.stream(numbersAssigned).limit(n).forEach(queue::offer);

        //removing elements
        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        //checking if the element present

        if (isPresent(queue, x)){
            System.out.println("true");
        } else if (!queue.isEmpty()){
            System.out.println(smallestElement(queue));
        } else {
            System.out.println("0");
        }

    }
    public static boolean isPresent(ArrayDeque<Integer> queue, int x) {
        return queue.contains(x);
    }
    public static int smallestElement(ArrayDeque<Integer> queue) {
        int smallestValue = Integer.MAX_VALUE;

        for (int currentValue : queue) {
            if (currentValue < smallestValue) {
                smallestValue = currentValue;
            }
        }
        return smallestValue;
    }
}
