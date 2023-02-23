package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countriesCount = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> countryMapData = new LinkedHashMap<>();
        for (int i = 0; i < countriesCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!countryMapData.containsKey(continent)) {

                countryMapData.put(continent, new LinkedHashMap<>());
                countryMapData.get(continent).put(country, new ArrayList<>());
                countryMapData.get(continent).get(country).add(city);

            } else {

                if (!countryMapData.get(continent).containsKey(country)) {
                    countryMapData.get(continent).put(country, new ArrayList<>());
                }
                countryMapData.get(continent).get(country).add(city);

            }
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : countryMapData.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Map.Entry<String, List<String>> entryValues : entry.getValue().entrySet()) {
                System.out.print(entryValues.getKey() + " -> ");

                for (int i = 0; i < entryValues.getValue().size(); i++) {

                    if (i != 0) {
                        System.out.print(", ");
                    }

                    System.out.print(entryValues.getValue().get(i));
                }
                System.out.println();
            }
        }
    }
}
