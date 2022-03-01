package lab4;

import lab4.client.GomokuClient;
import lab4.data.GomokuGameState;
import lab4.gui.GomokuGUI;
/**
 * Main class
 * @author Felix Martensson och Johnny Lam
 */
public class GomokuMain {
    /**
     * Main function
     * @param args User port
     */
    public static void main(String[] args) {
        /**
         * Default port
         */
        int port = 4000;
        if (args.length > 1) {
            throw new IllegalArgumentException();
        } else if (args.length == 1 && Integer.parseInt(args[0]) >= 0) {
            port = Integer.parseInt(args[0]);
        }

        GomokuClient client = new GomokuClient(port);
        GomokuGameState gameState = new GomokuGameState(client);
        GomokuGUI gui = new GomokuGUI(gameState, client);
        port = 4001;
        GomokuClient client2 = new GomokuClient(port);
        GomokuGameState gameState2 = new GomokuGameState(client2);
        GomokuGUI gui2 = new GomokuGUI(gameState2, client2);

    }
}