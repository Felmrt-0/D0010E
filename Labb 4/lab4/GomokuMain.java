package lab4;

import lab4.data.GomokuGameState;
import lab4.gui.GomokuGUI;

public class GomokuMain {
    public static void main(String[] args) {
        int port = 4000;
        if (args.length > 1) {
            throw new IllegalArgumentException();
        } else if (args.length == 1 && Integer.parseInt(args[0]) >= 0) {
            port = Integer.parseInt(args[0]);
        }

        GomokuClient client = new GomokuClient(port);
        GomokuGameState gameState = new GomokuGameState(client);
        GomokuGUI gui = new GomokuGUI(gameState, client);

    }
}