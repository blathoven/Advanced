package MultiDimensionalArraysExercise;
import java.util.*;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        String command = scanner.nextLine();


        while (!command.equals("stop")) {
            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int entryRow = tokens[0];
            int coordinateX = tokens[1];
            int coordinateY = tokens[2];

            int counter = (Math.abs(entryRow - coordinateX) + 1) + coordinateY;

            while (matrix[coordinateX][coordinateY] != 0) {

                if (freeSpaceFoundCloserToInitial(matrix, coordinateX, coordinateY)) {
                    while (matrix[coordinateX][coordinateY] != 0) {
                        coordinateY--;
                        counter--;
                    }
                } else if (freeSpaceFoundAfterInitial(matrix, coordinateX, coordinateY)) {
                    while (matrix[coordinateX][coordinateY] != 0) {
                        coordinateY++;
                        counter++;
                    }
                } else {
                    break;
                }
            }
            if (rowIsFull(matrix, coordinateX, coordinateY)) {
                System.out.printf("Row %d full\n", coordinateX);
            } else {
                matrix[coordinateX][coordinateY] = 1;
                System.out.println(counter);
            }

            command = scanner.nextLine();
        }
    }
    public static boolean freeSpaceFoundCloserToInitial(int[][] matrix, int coordinateX, int coordinateY) {
        while (coordinateY > 0) {
            if (matrix[coordinateX][coordinateY] == 0) {
                return true;
            }
            coordinateY--;
        }
        return false;
    }

    public static boolean freeSpaceFoundAfterInitial(int[][] matrix, int coordinateX, int coordinateY) {
        while (coordinateY < matrix[coordinateX].length) {
            if (matrix[coordinateX][coordinateY] == 0) {
                return true;
            }
            coordinateY++;
        }
        return false;
    }

    public static boolean rowIsFull(int[][] matrix, int coordinateX, int coordinateY) {
        return !freeSpaceFoundAfterInitial(matrix, coordinateX, coordinateY) && !freeSpaceFoundCloserToInitial(matrix, coordinateX, coordinateY);
    }


}
