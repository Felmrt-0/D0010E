package lab2;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

import java.awt.*;

public class Driver {

	public void run() {
		Room r1 = new Room(10, 10, Color.red);
		Room r2 = new Room(17, 17, Color.blue);
		Room r3 = new Room(43, 43, Color.yellow);
		Room r4 = new Room(42, 32, Color.blue);
		Room r5 = new Room(23, 12, Color.black);

		Level level = new Level();

		level.place(r1, 2, 3);
		level.place(r2, 12, 63);
		level.place(r3, 23, 35);
		level.place(r4, 34, 44);
		level.place(r5, 6, 83);

		r1.connectNorthTo(r2);
		r1.connectEastTo(r3);

		r2.connectSouthTo(r1);
		r2.connectWestTo(r3);

		r3.connectEastTo(r1);
		r3.connectEastTo(r2);

		r4.connectWestTo(r3);
		r4.connectEastTo(r5);

		r5.connectSouthTo(r1);
		r5.connectWestTo(r3);
		r5.connectEastTo(r4);
	}

}