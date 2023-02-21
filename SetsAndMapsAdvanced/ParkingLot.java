package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbersData = new LinkedHashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(",\\s+");

            String action = tokens[0];
            String carNumber = tokens[1];

            if (action.equals("IN")) {
                carNumbersData.add(carNumber);
            } else {
                carNumbersData.remove(carNumber);
            }

            command = scanner.nextLine();
        }

        String output = carNumbersData.isEmpty() ? "Parking Lot is Empty"
                : carNumbersData.stream().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);
    }
}

