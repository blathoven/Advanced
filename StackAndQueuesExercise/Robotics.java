package StackAndQueuesExercise;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsTokens = scanner.nextLine().split(";");

        String[] robot = new String[robotsTokens.length];
        int[] processTime = new int[robotsTokens.length];
        int[] workTime = new int[robotsTokens.length];

        for (int i = 0; i < robotsTokens.length; i++) {
            String[] data = robotsTokens[i].split("-");
            String robotName = data[0];
            int robotTime = Integer.parseInt(data[1]);

            robot[i] = robotName;
            processTime[i] = robotTime;
        }

        ArrayDeque<String> products = new ArrayDeque<>();

        int[] timeData = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();

        String inputProduct = scanner.nextLine();

        while (!inputProduct.equals("End")) {
            products.offer(inputProduct);

            inputProduct = scanner.nextLine();
        }

        int hours = timeData[0];
        int minutes = timeData[1];
        int seconds = timeData[2];

        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()) {
            beginSeconds++;

            String product = products.poll();

            boolean isWorking = false;

            for (int i = 0; i < robot.length; i++) {
                if (workTime[i] == 0 && !isWorking) {

                    workTime[i] = processTime[i];
                    isWorking = true;
                    printRobotData(robot[i], product, beginSeconds);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            if (!isWorking) {
                products.offer(product);
            }
        }
    }

    public static void printRobotData(String robot, String product, int beginSeconds) {

        long seconds = beginSeconds % 60;
        long minutes = (beginSeconds / 60) % 60;
        long hours = (beginSeconds / 3600) % 24;

        System.out.println(robot + " - " + product + String.format(" [%02d:%02d:%02d]", hours, minutes, seconds));
    }
}

