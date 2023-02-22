package SetsAndMapsAdvanced;

import java.util.*;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String currentGuest = scanner.nextLine();

        while (!currentGuest.equals("PARTY")) {

            guests.add(currentGuest);
            currentGuest = scanner.nextLine();
        }

        currentGuest = scanner.nextLine();

        while (!currentGuest.equals("END")) {

            guests.remove(currentGuest);
            currentGuest = scanner.nextLine();
        }

        System.out.println(guests.size());
        System.out.println(String.join(System.lineSeparator(), guests));
    }
}

