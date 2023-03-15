package SetsAndMapsAdvancedExercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryItemsData = new TreeMap<>();

        legendaryItemsData.put("shards", 0);
        legendaryItemsData.put("fragments", 0);
        legendaryItemsData.put("motes", 0);

        Map<String, Integer> junkItemsData = new TreeMap<>();

        boolean isObtained = false;
        String itemObtained = null;

        while (!isObtained) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (isLegendary(material)) {
                    legendaryItemsData.put(material, legendaryItemsData.get(material) + quantity);

                    if (legendaryItemsData.get(material) > 249) {
                        isObtained = true;

                        switch (material) {
                            case "shards":
                                itemObtained = "Shadowmourne";
                                break;
                            case "fragments":
                                itemObtained = "Valanyr";
                                break;
                            case "motes":
                                itemObtained = "Dragonwrath";
                        }

                        legendaryItemsData.put(material, legendaryItemsData.get(material) - 250);
                        System.out.println(itemObtained + " obtained!");
                    }
                } else {
                    junkItemsData.putIfAbsent(material, 0);
                    junkItemsData.put(material, junkItemsData.get(material) + quantity);
                }
                if (isObtained) {
                    break;
                }
            }
        }

        legendaryItemsData.entrySet().stream().sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .forEach(v -> System.out.println(v.getKey() + ": " + v.getValue()));

        junkItemsData.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(l -> System.out.println(l.getKey() + ": " + l.getValue()));
    }

    private static boolean isLegendary(String item) {
        return item.equals("shards") || item.equals("fragments") || item.equals("motes");
    }
}
