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

		r1.connectNorthTo(r2);
		r1.connectEastTo(r3);

		r2.connectSouthTo(r1);
		r2.connectWestTo(r3);

		r3.connectEastTo(r1);
		r3.connectEastTo(r2);
	}

}