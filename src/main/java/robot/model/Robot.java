package robot.model;

import robot.config.TableConfig;

import java.util.Optional;

public class Robot {
    private int x;
    private int y;
    private Direction direction;
    private boolean placed;

    public Robot() {
        this.placed = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void place(int x, int y, Direction direction) {
        if (x < TableConfig.MIN_X || x > TableConfig.MAX_X ||
            y < TableConfig.MIN_Y || y > TableConfig.MAX_Y) {
            return;
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.placed = true;
    }

    public void move() {
        if (!placed) {
            return;
        }

        switch (direction) {
            case NORTH -> {
                if(y < TableConfig.MAX_Y) y++;
            }
            case EAST  -> {
                if(x < TableConfig.MAX_X) x++;
            }
            case SOUTH -> {
                if(y > TableConfig.MIN_Y) y--;
            }
            case WEST  -> {
                if(x > TableConfig.MIN_X) x--;
            }
        }
    }

    public void turnLeft() {
        if (!placed) {
            return;
        }
        direction = direction.left();
    }

    public void turnRight() {
        if (!placed) {
            return;
        }
        direction = direction.right();
    }

    public Optional<String> getPosition() {
        if (!placed) {
            return Optional.empty();
        }
        return Optional.of(String.format("%d,%d,%s", x, y, direction));
    }
}
