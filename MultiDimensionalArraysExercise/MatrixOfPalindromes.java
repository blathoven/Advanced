package MultiDimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix;
        matrix = readMatrix(dimensions[0], dimensions[1]);

        printMatrix(matrix);

    }
    public static String[][] readMatrix(int rows, int cols) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {

            char firstAndLastLetters = (char) (row + 97);

            for (int col = 0; col < cols; col++) {

                char middleLetter = (char) ((row + col) + 97);

                matrix[row][col] = String.valueOf(firstAndLastLetters) + middleLetter + firstAndLastLetters;
            }
        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String currentElement : row) {
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }
}
