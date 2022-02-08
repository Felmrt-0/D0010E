package lab2;

import java.awt.Color;
import java.util.Random;
import java.util.Arrays;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;
import lab2.toolClasses.Vector2;

public class Driver {

  public void run() {
    Random r = new Random();
    int numRooms = r.nextInt(2) + 5; // Random number of rooms between 5 and 6
    
    Level level = new Level();
    
    Room[] rooms = new Room[numRooms];

    /*for (int i = 0; i < numRooms; i++) {
      int MAX_SIZE = 200;
      int MIN_SIZE = 70;
      int WINDOW_SIZE = 500;

      do {
        // Create a new room with random size and color
        rooms[i] = new Room(
            r.nextInt(MAX_SIZE-MIN_SIZE) + MIN_SIZE,
            r.nextInt(MAX_SIZE-MIN_SIZE) + MIN_SIZE,
            new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))
          );

      } while (
        // Place the newly created room
        !level.place(
            rooms[i],
            r.nextInt(WINDOW_SIZE - rooms[i].getSize().x),
            r.nextInt(WINDOW_SIZE - rooms[i].getSize().y)
          )
      );
    }*/

    Room r1 = new Room(200,100,Color.BLUE);
    Room r2 = new Room(100,60,Color.RED);
    Room r3 = new Room(70,30,Color.GREEN);
    Room r4 = new Room(170,60,Color.yellow);
    Room r5 = new Room(100,100,Color.white);
    Room r6 = new Room(40,200,Color.gray);
    Room r7 = new Room(270,160,Color.pink);
    Room r8 = new Room(120,70,Color.magenta);
    Room r9 = new Room(110,120,Color.orange);

    Level testLevel = new Level();

    testLevel.place(r1,50,40);
    testLevel.place(r2,30,25);
    testLevel.place(r3,210,20);
    testLevel.place(r4,230,100);
    testLevel.place(r5,20,80);
    testLevel.place(r6,90,10);
    testLevel.place(r7,20,20);
    testLevel.place(r8,80,50);
    testLevel.place(r9,130,100);

    LevelGUI lvlGUI = new LevelGUI(testLevel, "overlap test");


    class RoomWithDistance implements Comparable<RoomWithDistance> {
      Room r;
      float dist;
      public RoomWithDistance(Room room, float distance) {
        this.r = room;
        this.dist = distance;
      }
      @Override
      public int compareTo(RoomWithDistance o) {
        return Float.compare(this.dist, o.dist);
      }
    }
    
    // Connect the rooms using the following algorithm:
    // 1. For every room:
    // 2. Sort all rooms by distance to this room
    // 3. For every room (except the first == this) in the sorted list:
    // 4. Find the 45 degree offset quadrant (i.e. up/down/left/right instead of upRight/upLeft/downLeft/downRight)
    //    by comparing to the y = x and y = -x lines (-y is used as y=0 is the top of the screen)
    // 5. If the room is in a quadrant whose door is not used, connect the rooms

    /*for (int i = 0; i < numRooms; i++) {
      Room currentRoom = rooms[i];
      RoomWithDistance[] roomsWithDist = new RoomWithDistance[numRooms];
      for (int j = 0; j < numRooms; j++) {
        roomsWithDist[j] = new RoomWithDistance(rooms[j], currentRoom.getDistance(rooms[j]));
      }
      // Sort the rooms by distance
      Arrays.sort(roomsWithDist);

      for (RoomWithDistance room : roomsWithDist) {
        if (room.dist == 0) {
          continue;
        }

        Vector2 delta = room.r.getDelta(currentRoom);
        if (-delta.y >= delta.x && -delta.y > -delta.x && !currentRoom.isConnectedNorth()) {
          currentRoom.connectNorthTo(room.r);
        } else if (-delta.y <= delta.x && -delta.y < -delta.x && !currentRoom.isConnectedSouth()) {
          currentRoom.connectSouthTo(room.r);
        } else if (-delta.y <= delta.x && -delta.y > -delta.x && !currentRoom.isConnectedEast()) {
          currentRoom.connectEastTo(room.r);
        } else if (-delta.y >= delta.x && -delta.y < -delta.x && !currentRoom.isConnectedWest()) {
          currentRoom.connectWestTo(room.r);
        }
      }
    }*/

    // Select a random first location
    //level.firstLocation(rooms[r.nextInt(numRooms)]);

    // Render level in a GUI
    //new LevelGUI(level, "Maze");
  }


}
