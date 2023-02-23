package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentMap = new TreeMap<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String studentName = tokens[0];
            double studentGrade = Double.parseDouble(tokens[1]);

            if (!studentMap.containsKey(studentName)) {
                studentMap.put(studentName, new ArrayList<>());

                studentMap.get(studentName).add(studentGrade);
            } else {
                studentMap.get(studentName).add(studentGrade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentMap.entrySet()) {

            System.out.print(entry.getKey() + " -> ");
            double studentGrades = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                studentGrades += entry.getValue().get(i);

                System.out.printf("%.2f ", entry.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)\n", studentGrades / entry.getValue().size());
        }
    }
}
