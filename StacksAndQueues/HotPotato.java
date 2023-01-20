package StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kidList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> kidQueue = new ArrayDeque<>();

        int tossCount = Integer.parseInt(scanner.nextLine());

        int interactions = 1;
        while (kidList.size() != 1) {

            if (kidQueue.size() == 0) {
                Arrays.stream(kidList.toArray()).forEach(e -> kidQueue.offer(e.toString()));
            }

            if (interactions % tossCount != 0) {
                kidQueue.poll();
            } else if (interactions % tossCount == 0) {
                String removedKid = kidQueue.poll();
                kidList.remove(removedKid);
                System.out.println("Removed " + removedKid);
            }

            interactions++;
        }
        for (String name : kidList) {
            System.out.println("Last is " + name);
        }
    }
}
