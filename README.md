# Toy Robot Code Challenge

A simulation of a toy robot moving on a 5x5 square table. The robot can be placed, moved, and rotated using text commands via standard input.

---

## Requirements

| Tool        | Version   |
|-------------|-----------|
| Java (JDK)  | 17+       |
| Maven       | 3.6+      |

---

## Build

```bash
mvn clean package
```

This produces `target/toy-robot-code-challenge.jar`.

---

## Run

```bash
java -jar target/toy-robot-code-challenge.jar
```

Once running, enter commands one per line and press Enter to execute.

---

## Commands

| Command            | Description                                                       |
|--------------------|-------------------------------------------------------------------|
| `PLACE X,Y,FACING` | Place the robot at (X, Y) facing NORTH, EAST, SOUTH, or WEST     |
| `MOVE`             | Move the robot one step forward in the direction it is facing     |
| `LEFT`             | Rotate the robot 90° to the left                                  |
| `RIGHT`            | Rotate the robot 90° to the right                                 |
| `REPORT`           | Print the current position and direction of the robot             |

> The robot must be placed with `PLACE` before any other command takes effect.

### Example

```
PLACE 0,0,NORTH
MOVE
RIGHT
MOVE
REPORT
```

Output:
```
1,1,EAST
```

