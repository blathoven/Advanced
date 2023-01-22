package StackAndQueuesExercise.Memoization;

import java.util.Scanner;

public class Memoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Factorial factorial = new Factorial();

        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        int thirdDigit = Integer.parseInt(scanner.nextLine());

        System.out.println(factorial.calculate(firstDigit));
        System.out.println(factorial.calculate(secondDigit));
        System.out.println(factorial.calculate(thirdDigit));

    }
}
