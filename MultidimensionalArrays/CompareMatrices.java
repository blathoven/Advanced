package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];

        int[][] firstMatrix = fillMatrix(rows, scanner);

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        rows = dimensions[0];

        int[][] secondMatrix = fillMatrix(rows, scanner);

        String output = matricesAreEqual(firstMatrix, secondMatrix) ? "equal" : "not equal";

        System.out.println(output);

    }
    public static int[][] fillMatrix(int rows,  Scanner scanner) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {

            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }
        return matrix;
    }

    public static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {

            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
