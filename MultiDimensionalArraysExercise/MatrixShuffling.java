package MultiDimensionalArraysExercise;
import java.util.*;


public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = readMatrix(dimensions[0], dimensions[1], scanner);

        String[] commandLine = scanner.nextLine().split("\\s+");

        while (!commandLine[0].equals("END")) {

            if (commandLine.length == 5) {
                int row1 = Integer.parseInt(commandLine[1]);
                int col1 = Integer.parseInt(commandLine[2]);
                int row2 = Integer.parseInt(commandLine[3]);
                int col2 = Integer.parseInt(commandLine[4]);

                if (isValidCommand(commandLine[0], matrix, row1, col2, row2, col2)) {

                    swapElements(matrix, row1, col1, row2, col2);

                } else {
                    invalidCommand();
                }
            } else {
                invalidCommand();
            }

            commandLine = scanner.nextLine().split("\\s+");
        }

    }
    public static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static boolean isValidCommand(String commandInput, String[][] matrix, int row1,
                                         int col1, int row2, int col2) {
        return ((row1 < matrix.length && row1 >= 0) && (col1 < matrix[0].length && col1 >= 0)) &&
                ((row2 < matrix.length && row2 >= 0) && (col2 < matrix[0].length && col2 >= 0))
                && commandInput.equals("swap");
    }

    public static void swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {

        String firstElement = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = firstElement;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void invalidCommand() {
        System.out.println("Invalid input!");
    }
}
