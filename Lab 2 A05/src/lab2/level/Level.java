package lab2.level;

import java.util.Observable;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Level extends Observable {
  ArrayList<Room> rooms;
  Room currentRoom;
  boolean blockRooms = false; // komma ihåg om firstLocation() har körts

  public Level() {
    this.rooms = new ArrayList<Room>();
  }

  public boolean place(Room r, int x, int y) {
    // Don't allow more rooms after firstLocation() has been called
    if (blockRooms) {
      return false;
    }

    // Check if room collides with an existing room
    Rectangle newRoomBounds = new Rectangle(x, y, r.width, r.height);
    boolean collides = false;
    for (Room room: this.rooms) {
      Rectangle roomBounds = new Rectangle(room.x, room.y, room.width, room.height);
      if (newRoomBounds.intersects(roomBounds)) {
        collides = true;
        break;
      }
    }

    if (collides) {
      return false;
    } else {
      // If it doesn't collide with any existing rooms, add the new room and save its coordinates
      r.x = x;
      r.y = y;
      this.rooms.add(r);
      return true;
    }
  }

  public void firstLocation(Room r) {
    this.currentRoom = r;
    this.blockRooms = true;
  }
}
