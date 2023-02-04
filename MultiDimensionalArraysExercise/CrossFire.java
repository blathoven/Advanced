package MultiDimensionalArraysExercise;

import java.util.*;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = readMatrix(rows, cols);

        String[] inputLine = scanner.nextLine().split("\\s+");

        while (!inputLine[0].equals("Nuke")) {

            int firedRow = Integer.parseInt(inputLine[0]);
            int firedCol = Integer.parseInt(inputLine[1]);
            int radius = Integer.parseInt(inputLine[2]);

            for (int i = firedRow - radius; i <= firedRow + radius ; i++) {
                if (isInBounds(i, firedCol, matrix) && i != firedRow) {
                    matrix.get(i).remove(firedCol);
                }
            }
            for (int i = firedCol + radius; i >= firedCol - radius; i--) {
                if (isInBounds(firedRow, i, matrix)) {
                    matrix.get(firedRow).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);

            inputLine = scanner.nextLine().split("\\s+");
        }

        printMatrix(matrix);
    }

    public static List<List<Integer>> readMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
        return matrix;
    }

    public static boolean isInBounds(int row, int col, List<List<Integer>> matrix) {
        return (row >= 0 && row < matrix.size()) && (col >= 0 && col < matrix.get(row).size());
    }

    public static void printMatrix(List<List<Integer>> matrix) {

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }
}


