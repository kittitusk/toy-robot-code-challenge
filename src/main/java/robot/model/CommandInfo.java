package robot.model;

public class CommandInfo {
    private int x;
    private int y;
    private Direction direction;
    private CommandType command;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public CommandType getCommand() {
        return command;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCommand(CommandType command) {
        this.command = command;
    }
}
