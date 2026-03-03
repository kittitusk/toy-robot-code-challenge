package robot;

import robot.service.RobotService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        RobotService robotService = new RobotService();

        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                robotService.executeCommand(input);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
