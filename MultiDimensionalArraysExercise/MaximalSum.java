package MultiDimensionalArraysExercise;

import java.util.Scanner;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = readMatrix(dimensions[0], dimensions[1], scanner);

        int highestSum = Integer.MIN_VALUE;
        int[] startIndexes = new int[2];

        for (int row = 0; row < dimensions[0]; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                int currentRows = row;

                if (isInBounds(row, col, matrix)) {

                    int currentSum = 0;

                    while (currentRows <= row + 2) {

                        for (int i = col; i < col + 3; i++) {
                            currentSum += matrix[currentRows][i];
                        }
                        currentRows++;
                    }
                    if (currentSum > highestSum) {
                        highestSum = currentSum;

                        startIndexes[0] = row;
                        startIndexes[1] = col;
                    }
                } else {
                    break;
                }
            }
        }
        printMatrix(startIndexes[0], startIndexes[1], matrix, highestSum);
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {

        return (col + 2 < matrix[row].length) && row + 2 < matrix.length;

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
