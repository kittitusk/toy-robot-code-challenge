package robot;

import robot.service.RobotService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        RobotService robotService = new RobotService();

        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String output = robotService.executeCommand(input);
                if (output != null) {
                    System.out.println(output);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
