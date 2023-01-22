package StackAndQueuesExercise;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandLines = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < commandLines; i++) {

            int[] currentCommand = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            switch (currentCommand[0]){
                case 1: //push the element X into the stack
                    int element = currentCommand[1];
                    stack.push(element);
                    break;
                case 2: //delete the element present at the top of the stack
                    stack.pop();
                    break;
                case 3: //print the maximum element of the stack
                    System.out.println(maximumElement(stack));
            }

        }
    }
    public static int maximumElement(Deque<Integer> stack) {
        int maximumElement = Integer.MIN_VALUE;

        for (int currentElement : stack) {
            if (currentElement > maximumElement) {
                maximumElement = currentElement;
            }
        }
        return maximumElement;
    }
}
