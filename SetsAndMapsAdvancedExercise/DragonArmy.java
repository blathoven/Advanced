package SetsAndMapsAdvancedExercise;

import java.util.*;

public class DragonArmy {
    public static class DragonStats {

        private final String name;
        private final int damage;
        private final int health;
        private final int armor;

        public DragonStats(String name, int damage, int health, int armor) {

            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;

        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public int getArmor() {
            return armor;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dragonsCounts = Integer.parseInt(scanner.nextLine());

        Map<String, List<DragonStats>> dragonsData = new LinkedHashMap<>();

        for (int i = 0; i < dragonsCounts; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            List<DragonStats> dragonStats = new ArrayList<>();

            String type = tokens[0];
            String name = tokens[1];
            int damage = 45;
            if (!tokens[2].equals("null")) {
                damage = Integer.parseInt(tokens[2]);
            }
            int health = 250;
            if (!tokens[3].equals("null")) {
                health = Integer.parseInt(tokens[3]);
            }
            int armor = 10;
            if (!tokens[4].equals("null")) {
                armor = Integer.parseInt(tokens[4]);
            }

            DragonStats currentDragon = new DragonStats(name, damage, health, armor);
            dragonStats.add(currentDragon);

            dragonsData.putIfAbsent(type, new ArrayList<>());
            dragonsData.get(type).add(currentDragon);
        }

        for (Map.Entry<String, List<DragonStats>> entry : dragonsData.entrySet()) {
            String type = entry.getKey();

            List<DragonStats> currentDragon = entry.getValue();

            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;

            for (DragonStats dragonStats : currentDragon) {
                avgDamage += dragonStats.getDamage();
                avgHealth += dragonStats.getHealth();
                avgArmor += dragonStats.getArmor();
            }

            int listSize = entry.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, avgDamage / listSize, avgHealth / listSize,
                    avgArmor / listSize);

            dragonsData.get(entry.getKey()).stream().sorted(Comparator.comparing(DragonStats::getName))
                    .forEach((k) ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", k.getName(), k.getDamage(),
                            k.getHealth(), k.getArmor()));
        }
    }
}
