
package lab2.level;

import java.util.Observable;
import java.util.ArrayList;
import java.awt.Rectangle;


public class Level extends Observable {

    ArrayList<Room> roomList;
    Room spawn;
    boolean spawnCheck = false;

    public Level() {
        this.roomList = new ArrayList<>();
    }

    public boolean place(Room r, int x, int y) {

        if(spawnCheck){
            return false;
            //System.out.println("Spawn placed");
        }

        Rectangle rect = new Rectangle(x, y, r.dx, r.dy);
        for (Room room : roomList) {
            Rectangle tempRect = new Rectangle(room.posX, room.posY, room.dx, room.dy);
            if (rect.intersects(tempRect)) {
                System.out.println("Rum överlappar.");
                return false;
            }
        }
        r.posX = x;
        r.posY = y;
        roomList.add(r);
        System.out.println("Rum skapad");
        return true;
    }

    public void firstLocation(Room r) {
        spawn = r;
        spawnCheck = true;
    }

}
