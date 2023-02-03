package MultiDimensionalArraysExercise;

import java.util.Scanner;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

        int[][] matrix = readMatrix(dimensions[0], dimensions[1], scanner);

        int[] result = findMaximalSum(matrix);

        printMatrix(result[0], result[1], matrix, result[2]);
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        }
        return matrix;
    }

    public static int[] findMaximalSum(int[][] matrix) {
        int highestSum = Integer.MIN_VALUE;
        int[] startIndexes = new int[3];
        
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        currentSum += matrix[i][j];
                    }
                }
                if (currentSum > highestSum) {
                    highestSum = currentSum;
                    startIndexes[0] = row;
                    startIndexes[1] = col;
                    startIndexes[2] = highestSum;
                }
            }
        }
        return startIndexes;
    }

    public static void printMatrix(int rows, int cols, int[][] matrix, int sum) {
        System.out.println("Sum = " + sum);
        for (int row = rows; row < rows + 3; row++) {
            for (int col = cols; col < cols + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
