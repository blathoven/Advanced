package StackAndQueuesExercise;

import java.util.*;

public class ReverseNumberWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberInput = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();

        Arrays.stream(numberInput).forEach(reversedNumbers::push);

        for (int currentElement : reversedNumbers) {
            System.out.print(currentElement + " ");
        }
    }
}
