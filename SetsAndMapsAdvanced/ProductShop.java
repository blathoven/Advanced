package SetsAndMapsAdvanced;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> companyData = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(",\\s+");

            String companyName = tokens[0];
            String productName = tokens[1];
            Double productPrice = Double.parseDouble(tokens[2]);

            if (!companyData.containsKey(companyName)) {
                companyData.put(companyName, new LinkedHashMap<>());

                companyData.get(companyName).put(productName, productPrice);
            } else {
                companyData.get(companyName).put(productName, productPrice);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : companyData.entrySet()) {
            System.out.println(entry.getKey() + "->");

            for (Map.Entry<String, Double> values : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", values.getKey(), values.getValue());
            }
        }
    }
}
