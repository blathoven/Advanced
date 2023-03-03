package SetsAndMapsAdvanced;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsMapData = new TreeMap<>();
        for (int i = 0; i < studentsCount; i++) {

            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                    .toArray();

            studentsMapData.putIfAbsent(studentName, new ArrayList<>());
            Arrays.stream(grades).forEach(x -> {
                studentsMapData.get(studentName).add(x);
            });
        }
        for (Map.Entry<String, List<Double>> entry : studentsMapData.entrySet()) {
            List<Double> grades = entry.getValue();

            studentsMapData.forEach((k, v) -> {
                double sum = 0;
                for (double currentValue : v) {
                    sum += currentValue;
                }
                double averageGrade = sum / v.size();
                System.out.printf("%s is graduated with %f\n", entry.getKey(), averageGrade);
            });
        }
    }
}
