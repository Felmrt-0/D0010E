
package lab2.level;

import java.awt.Color;


public class Room {

    Room northWall = null;
    Room westWall = null;
    Room eastWall = null;
    Room southWall = null;

    Color floorColor;

    //Size
    int dx = 0;
    int dy = 0;
    //Coordinates
    int posX;
    int posY;

    public Room(int dx, int dy, Color color) {
        this.dx = dx;
        this.dy = dy;
        this.floorColor = color;
        System.out.println(dx + " " + dy + " " + color);

    }

    public void connectNorthTo(Room r) {
        this.northWall = r;
    }

    public void connectEastTo(Room r) {
        this.eastWall = r;
    }

    public void connectSouthTo(Room r) {
        this.southWall = r;
    }

    public void connectWestTo(Room r) {
        this.westWall = r;
    }
}
