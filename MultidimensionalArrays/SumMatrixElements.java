package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = readMatrix(dimensions[0], dimensions[1], scanner);

        System.out.println(dimensions[0]);
        System.out.println(dimensions[1]);
        System.out.println(getSum(matrix));

    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }

    public static int getSum(int[][] matrix) {
        int sum = 0;

        for (int[] ints : matrix) {
            for (int col : ints) {
                sum += col;
            }
        }
        return sum;
    }
}

