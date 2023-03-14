package SetsAndMapsAdvancedExercise;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> countryData = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String commandLine = scanner.nextLine();
            if (commandLine.equals("report")) {
                break;
            }

            String[] tokens = commandLine.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            countryData.putIfAbsent(country, new TreeMap<>());
            Map<String, Integer> cityData = countryData.get(country);
            cityData.put(city, population);
        }

        List<Map.Entry<String, Integer>> totalPopulationData = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> countryEntry : countryData.entrySet()) {
            String country = countryEntry.getKey();
            int totalPopulation = 0;

            for (int population : countryEntry.getValue().values()) {
                totalPopulation += population;
            }

            totalPopulationData.add(new AbstractMap.SimpleEntry<>(country, totalPopulation));
        }

        totalPopulationData.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : totalPopulationData) {
            String country = entry.getKey();
            int totalPopulation = entry.getValue();

            System.out.printf("%s (total population: %d)%n", country, totalPopulation);

            Map<String, Integer> cities = countryData.get(country);

            List<Map.Entry<String, Integer>> totalCityPopulationData = new ArrayList<>(cities.entrySet());

            totalCityPopulationData.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for (Map.Entry<String, Integer> cityDataEntry : totalCityPopulationData) {
                System.out.printf("=>%s: %d%n", cityDataEntry.getKey(), cityDataEntry.getValue());
            }
        }
    }
}