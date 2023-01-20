package StacksAndQueues;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;


public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (true) {
            String printCommand = scanner.nextLine();

            if (printCommand.equals("print")) {
                break;
            } else if (printCommand.equals("cancel")) {
                if (printerQueue.size() == 0) {
                    System.out.println("Printer is on standby");
                } else {
                    String removedElement = printerQueue.poll();
                    System.out.println("Canceled " + removedElement);
                }
            } else {
                printerQueue.offer(printCommand);
            }
        }
        for (String currentElement : printerQueue) {
            System.out.println(currentElement);
        }
    }
}
