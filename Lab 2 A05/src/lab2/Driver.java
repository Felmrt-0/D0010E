package lab2;

import java.awt.Color;
import java.util.Random;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

  public void run() {
    Random r = new Random();
    int numRooms = r.nextInt(2) + 5; // Random number of rooms between 5 and 6
    
    Level level = new Level();
    
    Room[] rooms = new Room[numRooms];

    for (int i = 0; i < numRooms; i++) {
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

      if (i != 0) {
        // Connect the room to previous with doors
        rooms[i - 1].connectNorthTo(rooms[i]);
        rooms[i].connectSouthTo(rooms[i - 1]); // Detta gör att vi får en dubbelriktad graf
      }
    }

    // Select a random first location
    level.firstLocation(rooms[r.nextInt(numRooms)]);

    // Render level in a GUI
    new LevelGUI(level, "Maze");
  }

}