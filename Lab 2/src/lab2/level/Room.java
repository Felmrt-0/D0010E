
package lab2.level;

import java.awt.Color;


public class Room {

    Room northWall = null;
    Room westWall = null;
    Room eastWall = null;
    Room southWall = null;

    Color floorColor;

    int width = 0;
    int height = 0;

    public Room(int dx, int dy, Color color) {
    System.out.print(dx + " " + dy + " " + color);

    }

    public void connectNorthTo(Room r) {

    }

    public void connectEastTo(Room r) {

    }

    public void connectSouthTo(Room r) {

    }

    public void connectWestTo(Room r) {

    }
}
