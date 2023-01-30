package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols,  scanner);

        char[][] modifiedMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                char fillChar = firstMatrix[row][col] == secondMatrix[row][col] ? firstMatrix[row][col] : '*';

                modifiedMatrix[row][col] = fillChar;
            }
        }

        for (char[] row : modifiedMatrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String inputLine = scanner.nextLine();
            String[] inputLineArr = inputLine.split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = inputLineArr[col].charAt(0);

                matrix[row][col] = currentChar;
            }


        }
        return matrix;
    }
}

