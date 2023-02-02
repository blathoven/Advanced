package MultiDimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(dimensions, scanner);

        int diagonalDifference = Math.abs(diagonalSum(matrix, dimensions)[0] - diagonalSum(matrix,dimensions)[1]);

        System.out.println(diagonalDifference);

    }
    public static int[][] readMatrix(int dimensions, Scanner scanner) {
        int[][] matrix = new int[dimensions][dimensions];

        for (int row = 0; row < dimensions; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }

    public static int[] diagonalSum(int[][] matrix, int dimension) {
        int[] diagonalSum = new int[2];

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        int row = 0;
        for (int col = 0; col < matrix[dimension - 1].length; col++) {

            primaryDiagonal = primaryDiagonal + (matrix[row][col]);
            secondaryDiagonal = secondaryDiagonal + (matrix[(dimension - row) - 1][col]);

            row++;
        }
        diagonalSum[0] = primaryDiagonal;
        diagonalSum[1] = secondaryDiagonal;

        return diagonalSum;
    }
}
