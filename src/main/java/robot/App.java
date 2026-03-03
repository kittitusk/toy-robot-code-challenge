package robot;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                System.out.println("Received command: " + input);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
