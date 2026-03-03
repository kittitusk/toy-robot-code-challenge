package robot.service;

import robot.model.CommandInfo;
import robot.model.CommandType;
import robot.model.Direction;
import robot.model.Robot;


public class RobotService {
    private final Robot robot;

    public RobotService() {
        this.robot = new Robot();
    }

    public String executeCommand(String command) {
        CommandInfo validateCommandInfo = validateAndGetCommandInfo(command);

        if (validateCommandInfo == null) {
            return null;
        }

        switch (validateCommandInfo.getCommand()) {
            case PLACE -> robot.place(validateCommandInfo.getX(), validateCommandInfo.getY(), validateCommandInfo.getDirection());
            case MOVE -> robot.move();
            case LEFT -> robot.turnLeft();
            case RIGHT -> robot.turnRight();
            case REPORT -> {
                return handleReport(robot.getPosition().orElse(null));
            }
        }

        return null;
    }

    private String handleReport(String position) {
        if(position == null) {
            return null;
        }

        return String.format("Output: %s", position);
    }

    private CommandInfo validateAndGetCommandInfo(String command) {
        if (command == null || command.trim().isEmpty()) {
            return null;
        }

        String[] parts = command.trim().split(" ");
        if (parts.length == 0) {
            return null;
        }

        try {
            CommandType action = CommandType.valueOf(parts[0].toUpperCase());

            CommandInfo cmd = new CommandInfo();
            cmd.setCommand(action);

            if (action == CommandType.PLACE) {
                if (parts.length < 2) {
                    return null;
                }

                String[] args = parts[1].split(",");
                if (args.length == 3) {
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    Direction direction = Direction.valueOf(args[2].toUpperCase());
                    cmd.setX(x);
                    cmd.setY(y);
                    cmd.setDirection(direction);
                } else {
                    return null;
                }
            }

            return cmd;
        } catch (Exception e) {
            return null;
        }
    }
}
