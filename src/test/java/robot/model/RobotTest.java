package robot.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot();
        assertFalse(robot.isPlaced());
    }

    @Test
    void testPlaceValid() {
        robot.place(0,0,Direction.NORTH);
        assertTrue(robot.isPlaced());
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
        assertEquals("0,0,NORTH", robot.getPosition().orElse(null));
    }

    @Test
    void testPlaceInvalid() {
        robot.place(-1,0,Direction.NORTH);
        assertFalse(robot.isPlaced());

        robot.place(0,-1,Direction.NORTH);
        assertFalse(robot.isPlaced());

        robot.place(5,5,Direction.NORTH);
        assertFalse(robot.isPlaced());
    }

    @Test
    void testNullDirection() {
        robot.place(0,0,null);
        assertFalse(robot.isPlaced());
    }

    @Test
    void testMove() {
        robot.place(0,0,Direction.NORTH);
        assertTrue(robot.isPlaced());
        robot.move();
        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals("0,1,NORTH", robot.getPosition().orElse(null));

        robot.turnRight();
        robot.move();
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals("1,1,EAST", robot.getPosition().orElse(null));

        robot.turnRight();
        robot.move();
        assertEquals(1, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals("1,0,SOUTH", robot.getPosition().orElse(null));

        robot.turnRight();
        robot.move();
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals("0,0,WEST", robot.getPosition().orElse(null));
    }

    @Test
    void testMoveBoundary() {
        robot.place(4, 4, Direction.NORTH);
        robot.move();

        assertEquals(4, robot.getX());
        assertEquals(4, robot.getY());
        assertEquals("4,4,NORTH", robot.getPosition().orElse(null));

        robot.place(4, 4, Direction.EAST);
        robot.move();

        assertEquals(4, robot.getX());
        assertEquals(4, robot.getY());
        assertEquals("4,4,EAST", robot.getPosition().orElse(null));


        robot.place(0, 0, Direction.SOUTH);
        robot.move();

        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals("0,0,SOUTH", robot.getPosition().orElse(null));

        robot.place(0, 0, Direction.WEST);
        robot.move();

        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals("0,0,WEST", robot.getPosition().orElse(null));
    }

    @Test
    void testMoveWithoutPlace() {
        robot.move();
        assertFalse(robot.isPlaced());
    }

    @Test
    void testTurn() {
        robot.place(0,0,Direction.NORTH);
        assertTrue(robot.isPlaced());

        robot.turnLeft();
        assertEquals(Direction.WEST, robot.getDirection());
        assertEquals("0,0,WEST", robot.getPosition().orElse(null));

        robot.turnLeft();
        assertEquals(Direction.SOUTH, robot.getDirection());
        assertEquals("0,0,SOUTH", robot.getPosition().orElse(null));

        robot.turnLeft();
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals("0,0,EAST", robot.getPosition().orElse(null));

        robot.turnLeft();
        assertEquals(Direction.NORTH, robot.getDirection());
        assertEquals("0,0,NORTH", robot.getPosition().orElse(null));

        robot.turnRight();
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals("0,0,EAST", robot.getPosition().orElse(null));

        robot.turnRight();
        assertEquals(Direction.SOUTH, robot.getDirection());
        assertEquals("0,0,SOUTH", robot.getPosition().orElse(null));

        robot.turnRight();
        assertEquals(Direction.WEST, robot.getDirection());
        assertEquals("0,0,WEST", robot.getPosition().orElse(null));

        robot.turnRight();
        assertEquals(Direction.NORTH, robot.getDirection());
        assertEquals("0,0,NORTH", robot.getPosition().orElse(null));
    }

    @Test
    void testTurnWithoutPlace() {
        robot.turnLeft();
        assertFalse(robot.isPlaced());

        robot.turnRight();
        assertFalse(robot.isPlaced());
    }

    @Test
    void testPositionWithoutPlace() {
        assertTrue(robot.getPosition().isEmpty());
    }
}
