package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> previousPages = new ArrayDeque<String>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        String currentPage = "";

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Home")) {

            if (!inputLine.equals("back") && !inputLine.equals("forward")) {
                currentPage = inputLine;
                previousPages.push(inputLine);
                System.out.println(previousPages.peek());
                forwardPages.clear();
            } else if (inputLine.equals("back")) {
                if (previousPages.size() == 1 || previousPages.size() == 0) {
                    System.out.println("no previous URLs");
                } else {
                    currentPage = previousPages.pop();
                    forwardPages.push(currentPage);
                    System.out.println(previousPages.peek());
                }
            } else {
                if (forwardPages.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    currentPage = forwardPages.pop();

                    System.out.println(currentPage);
                }

            }

            inputLine = scanner.nextLine();

            if (!currentPage.equals("")) {
                switch (inputLine) {
                    case "forward":
                        if (previousPages.contains(currentPage)) {
                            break;
                        }
                        previousPages.push(currentPage);
                }
            }
        }
    }
}
