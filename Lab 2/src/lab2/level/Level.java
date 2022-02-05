
package lab2.level;

import java.util.Observable;
import java.util.ArrayList;
import java.awt.Rectangle;


public class Level extends Observable {

    ArrayList<Room> roomList;

    public Level() {
        this.roomList = new ArrayList<Room>();
    }

    public boolean place(Room r, int x, int y) {
        Rectangle rect = new Rectangle(x, y, r.dx, r.dy);
        for (Room room : roomList) {
            Rectangle tempRect = new Rectangle(room.posX, room.posY, room.dx, room.dy);
            if (rect.intersects(tempRect)) {
                return false;
            }
        }
        r.posX = x;
        r.posY = y;
        roomList.add(r);
        return true;
    }

    public void firstLocation(Room r) {

    }

}
