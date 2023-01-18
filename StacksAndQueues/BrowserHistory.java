package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browsers = new ArrayDeque<String>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Home")) {

            if (!inputLine.equals("back")) {
                browsers.push(inputLine);
                System.out.println(browsers.peek());
            } else {
                if (browsers.size() == 1 || browsers.size() == 0) {
                    System.out.println("no previous URLs");
                } else {
                    browsers.pop();
                    System.out.println(browsers.peek());
                }
            }

            inputLine = scanner.nextLine();
        }
    }
}
