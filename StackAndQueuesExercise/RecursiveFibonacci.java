package StackAndQueuesExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberInput = Integer.parseInt(scanner.nextLine());

        Map<Integer, Long> memoization = new HashMap<>();
        long result = getFibonacci(numberInput, memoization);

        System.out.println(result);

    }
    public static long getFibonacci(int input, Map<Integer, Long> memoization) {
        long result;

        if (input <= 1) {
            return 1;
        } else {
            if (memoization.containsKey(input)) {
                return memoization.get(input);
            } else {
                result = getFibonacci(input - 1, memoization) + getFibonacci(input - 2, memoization);
            }
        }
        return result;
    }
}
