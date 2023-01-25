package StackAndQueuesExercise;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantsCount = Integer.parseInt(scanner.nextLine());
        String[] plantsInput = scanner.nextLine().split("\\s+");
        int[] plants = new int[plantsCount];
        int[] days = new int[plantsCount];

        for (int i = 0; i < plantsCount; i++) {
            plants[i] = Integer.parseInt(plantsInput[i]);
        }

        Deque<Integer> indices = new ArrayDeque<>();
        indices.push(0);
        for (int i = 1; i < plantsCount; i++) {
            int maxDays = 0;
            while (!indices.isEmpty() && plants[indices.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[indices.pop()]);
            }
            if (!indices.isEmpty()) {
                days[i] = maxDays + 1;
            }
            indices.push(i);
        }
        System.out.println(getLastDay(days));
    }
    private static int getLastDay(int[] days) {
        int lastDay = 0;
        for (int day : days) {
            if (day > lastDay) {
                lastDay = day;
            }
        }
        return lastDay;
    }
}


//Map<Integer, Integer> plants = new LinkedHashMap<>();
//        Map<Integer, Integer> plantsModified = new LinkedHashMap<>();
//
//        int totalPlantsCount = Integer.parseInt(scanner.nextLine());
//
//        int[] pesticideAmounts = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
//                .toArray();
//
//        ArrayDeque<Integer> leftPlants = new ArrayDeque<>();
//        for (int i = 1; i <= totalPlantsCount; i++) {
//            plants.put(i, pesticideAmounts[i - 1]);
//        }
//        int totalDays = 0;
//        while (true) {
//
//            boolean stillWorkToDo = false;
//
//            for (Map.Entry<Integer, Integer> entry : plants.entrySet()) {
//
//                if (leftPlants.isEmpty()) {
//                    leftPlants.push(entry.getValue());
//                    plantsModified.put(entry.getKey(), entry.getValue());
//                } else {
//                    if (entry.getValue() <= leftPlants.peek()) {
//                        plantsModified.put(entry.getKey(), entry.getValue());
//                        leftPlants.push(entry.getValue());
//                    } else {
//                        stillWorkToDo = true;
//                        leftPlants.push(entry.getValue());
//                    }
//                }
//            }
//            if (stillWorkToDo) {
//                plants = new LinkedHashMap<>();
//                for (Map.Entry<Integer,Integer> entryGo : plantsModified.entrySet()) {
//                    plants.put(entryGo.getKey(), entryGo.getValue());
//                    leftPlants = new ArrayDeque<>();
//                }
//                plantsModified = new LinkedHashMap<>();
//                totalDays++;
//            } else {
//                break;
//            }
//        }
//        System.out.println(totalDays);