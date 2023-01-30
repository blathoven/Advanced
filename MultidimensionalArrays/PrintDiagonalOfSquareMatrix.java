package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(matrixSize, matrixSize, scanner);

        int[][] diagonals = new int[2][matrixSize];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (col == row) {
                    diagonals[0][row] = matrix[row][col];
                    diagonals[1][row] = matrix[(matrix.length - 1) - row][col];
                }
            }
        }
        printMatrix(diagonals);
    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static void printMatrix(int[][] diagonals) {
        for (int[] row : diagonals) {

            for (int currentElement : row) {
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }
}
