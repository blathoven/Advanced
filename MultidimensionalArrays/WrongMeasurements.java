package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(dimension, scanner);

        int[] replaceNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int invalidValue = matrix[replaceNumber[0]][replaceNumber[1]];

        int colsLength = matrix[0].length;
        int[][] modifiedMatrix = new int[dimension][colsLength];

        for (int row = 0; row < dimension; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == invalidValue) {

                    modifiedMatrix[row][col] = getSum(matrix, invalidValue, row, col);
                } else {
                    modifiedMatrix[row][col] = matrix[row][col];
                }
            }
        }
        printMatrix(modifiedMatrix);
    }

    public static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");

            int[] matrixInt = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                matrixInt[i] = Integer.parseInt(arr[i]);
            }
            matrix[row] = matrixInt;
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {

            for (int currentDigit : row) {
                System.out.print(currentDigit + " ");
            }
            System.out.println();
        }
    }

    public static int getSum(int[][] matrix, int invalidValue, int row, int col) {
        //up
        int sum = 0;
        if (row != matrix.length - 1) {
            if (matrix[row + 1][col] != invalidValue) {
                sum += matrix[row + 1][col];
            }
        }
        //down
        if (row != 0) {
            if (matrix[row - 1][col] != invalidValue) {
                sum += matrix[row - 1][col];
            }
        }
        //right
        if (col != matrix[row].length - 1) {
            if (matrix[row][col + 1] != invalidValue) {
                sum += matrix[row][col + 1];
            }
        }
        //left
        if (col != 0) {
            if (matrix[row][col - 1] != invalidValue) {
                sum += matrix[row][col - 1];
            }
        }
        return sum;
    }
}
