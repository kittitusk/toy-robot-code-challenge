package robot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotServiceTest {
    private RobotService robotService;

    @BeforeEach
    void setUp() {
        robotService = new RobotService();
    }

    @Test
    void testExecuteValidCommand() {
        robotService.executeCommand("PLACE 0,0,NORTH");
        robotService.executeCommand("MOVE");
        robotService.executeCommand("RIGHT");
        robotService.executeCommand("MOVE");
        String result = robotService.executeCommand("REPORT");
        assertEquals("Output: 1,1,EAST", result);
    }

    @Test
    void testInvalidPosition() {
        assertNull(robotService.executeCommand("PLACE 5,5,NORTH"));
        String result = robotService.executeCommand("REPORT");
        assertNull(result);
    }

    @Test
    void testInvalidCommand() {
        assertNull(robotService.executeCommand("JUMP"));
        String result1 = robotService.executeCommand("REPORT");
        assertNull(result1);

        assertNull(robotService.executeCommand("PLACE 0,0"));
        String result2 = robotService.executeCommand("REPORT");
        assertNull(result2);

        assertNull(robotService.executeCommand("PLACE 0,0,NORTHWEST"));
        String result3 = robotService.executeCommand("REPORT");
        assertNull(result3);

        assertNull(robotService.executeCommand("PLACE     0,0,NORTHWEST"));
        String result4 = robotService.executeCommand("REPORT");
        assertNull(result4);

        assertNull(robotService.executeCommand("PLACE hi,hello,NORTH"));
        String result5 = robotService.executeCommand("REPORT");
        assertNull(result5);

        assertNull(robotService.executeCommand("PLACE 0, 0, NORTH"));
        String result6 = robotService.executeCommand("REPORT");
        assertNull(result6);
    }

    @Test
    void testMoveWithoutPlace() {
        robotService.executeCommand("MOVE");
        String result = robotService.executeCommand("REPORT");
        assertNull(result);
    }

    @Test
    void testTurnWithoutPlace() {
        robotService.executeCommand("LEFT");
        String result = robotService.executeCommand("REPORT");
        assertNull(result);
    }

    @Test
    void testReportWithoutPlace() {
        String result = robotService.executeCommand("REPORT");
        assertNull(result);
    }

    @Test
    void testMultiplePlaceCommands() {
        robotService.executeCommand("PLACE 0,0,NORTH");
        robotService.executeCommand("MOVE");
        robotService.executeCommand("PLACE 1,1,EAST");
        String result = robotService.executeCommand("REPORT");
        assertEquals("Output: 1,1,EAST", result);
    }

    @Test
    void testTrimmedCommand() {
        robotService.executeCommand("   PLACE 0,0,NORTH   ");
        robotService.executeCommand("   MOVE   ");
        String result = robotService.executeCommand("   REPORT   ");
        assertEquals("Output: 0,1,NORTH", result);
    }

    @Test
    void testCaseSensitivity() {
        robotService.executeCommand("place 0,0,north");
        robotService.executeCommand("move");
        robotService.executeCommand("Right");
        robotService.executeCommand("moVe");
        robotService.executeCommand("left");
        String result = robotService.executeCommand("report");
        assertEquals("Output: 1,1,NORTH", result);
    }
}
