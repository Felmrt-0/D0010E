package lab4;

import lab4.data.GomokuGameState;
import lab4.gui.GomokuGUI;

class GomokuMain {
    public GomokuMain {

    }

    public static void main(String[] args) {
        int port = 4000;
        if (args.length > 1){
            throw new
        }
        else if (args.length == 1 && args =>0){
            port = args;
        }

        GomokuClient client = new GomokuClient(port);
        GomokuGameState gameState = new GomokuGameState(client);
        GomokuGUI gui = new GomokuGUI(gameState, client);

    }
}