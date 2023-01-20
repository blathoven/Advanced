package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int digitInput = Integer.parseInt(scanner.nextLine());

        if (digitInput == 0) {
            System.out.println(0);
        }

        while (digitInput != 0) {

            stack.push(digitInput % 2); //The remainder

            digitInput /= 2;
        }

        for (int currentDigit : stack) {
            System.out.print(currentDigit);
        }
    }
}
