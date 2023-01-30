package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = readArray(dimensions[0], dimensions[1], scanner);

        int[][] highestValues = new int[2][2];

        int highestColSum = Integer.MIN_VALUE;
        for (int row = 0; row < dimensions[0] - 1; row++) {

            for (int col = 0; col < dimensions[1] - 1; col++) {

                int currentSum = (matrix[row][col] + matrix[row][col + 1])
                        + (matrix[row + 1][col] + matrix[row + 1][col + 1]);

                if (currentSum > highestColSum) {
                    highestColSum = currentSum;

                    highestValues[0][0] = matrix[row][col];
                    highestValues[0][1] = matrix[row][col + 1];

                    highestValues[1][0] = matrix[row + 1][col];
                    highestValues[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int[] row : highestValues) {
            for (int currentElement : row) {
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
        System.out.println(highestColSum);
    }

    private static int[][] readArray(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

}
