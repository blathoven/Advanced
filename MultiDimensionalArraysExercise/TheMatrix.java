package MultiDimensionalArraysExercise;
import java.util.*;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = readMatrix(rows, cols, scanner);

        char fillChar = scanner.nextLine().charAt(0);

        int[] firstPositionData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int startRow = firstPositionData[0];
        int startCol = firstPositionData[1];

        char startChar = matrix[startRow][startCol];

        fillMatrix(matrix, startRow, startCol, fillChar, startChar);

        printMatrix(matrix);


    }
    private static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
        return matrix;
    }

    private static void fillMatrix(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            fillMatrix(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) {
            fillMatrix(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) {
            fillMatrix(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) {
            fillMatrix(matrix, row, col - 1, fillChar, startChar);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}




