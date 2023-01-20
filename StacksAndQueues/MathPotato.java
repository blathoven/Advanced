package StacksAndQueues;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kidsQueue = new PriorityQueue<>();
        Arrays.stream(inputLine).forEach(kidsQueue::offer);

        int cycle = 1;

        while (kidsQueue.size() > 1) {

            for (int i = 1; i < tossCount; i++) {
                kidsQueue.offer(Objects.requireNonNull(kidsQueue.poll()));
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + kidsQueue.peek());
            } else {
                System.out.println("Removed " + kidsQueue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kidsQueue.poll());

    }
    public static boolean isPrime(int number) {
        boolean isPrime = true;
        if (number == 0 || number == 1) {
            isPrime = false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
