/*
 * Created on 2007 feb 8
 */
package lab4.data;

import java.util.Observable;
import java.util.Observer;

import lab4.client.GomokuClient;

import javax.print.attribute.standard.MediaSize;

/**
 * @author Felix Mårtensson och Johnny Lam
 *
 * Represents the state of a game
 */

public class GomokuGameState extends Observable implements Observer {

    // Game variables
    public final int DEFAULT_SIZE = 15;
    private GameGrid gameGrid;

    //Possible game states
    private final int NOT_STARTED = 0;
    private final int MY_TURN = 1;
    private final int OTHER_TURN = 2;
    private final int FINISHED = 3;
    private int currentState;

    private GomokuClient client;

    private String message;

    /**
     * The constructor
     *
     * @param gc The client used to communicate with the other player
     */
    public GomokuGameState(GomokuClient gc) {
        client = gc;
        client.addObserver(this);
        gc.setGameState(this);
        currentState = NOT_STARTED;
        gameGrid = new GameGrid(DEFAULT_SIZE);
    }


    /**
     * Returns the message string
     *
     * @return the message string
     */
    public String getMessageString() {
        return message;
    }

    /**
     * Returns the game grid
     *
     * @return the game grid
     */
    public GameGrid getGameGrid() {
        return gameGrid;
    }

    /**
     * This player makes a move at a specified location
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void move(int x, int y) {
        switch (currentState) {
            case NOT_STARTED:
                message = "No game in progress.";
                break;
            case MY_TURN:
                if (gameGrid.move(x, y, gameGrid.ME)) {
                    if (gameGrid.isWinner(gameGrid.ME)) {
                        message = "You win.";
                        client.sendMoveMessage(x, y);
                        currentState = FINISHED;
                    } else {
                        currentState = OTHER_TURN;
                        client.sendMoveMessage(x, y);
                        message = "Opponent's turn.";
                    }
                } else {
                    message = "That move is not allowed.";
                }
                break;
            case OTHER_TURN:
                message = "It is not your turn.";
                break;
            case FINISHED:
                message = "Game is finished. Start another game.";
                break;
            default:
                message = "Something went wrong.";
                break;
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Starts a new game with the current client
     */
    public void newGame() {
        if (currentState == FINISHED || currentState == NOT_STARTED) {
            return;
        } else {
            gameGrid.clearGrid();
            currentState= OTHER_TURN;
            message = "Opponent's turn.";
            client.sendNewGameMessage();
            setChanged();
            notifyObservers();
        }
    }

    /**
     * Other player has requested a new game, so the
     * game state is changed accordingly
     */
    public void receivedNewGame() {
        gameGrid.clearGrid();
        currentState = MY_TURN;
        message = "Opponent started a new game started, it is your turn.";
        setChanged();
        notifyObservers();
    }

    /**
     * The connection to the other player is lost,
     * so the game is interrupted
     */
    public void otherGuyLeft() {
        gameGrid.clearGrid();
        message = "The other player has disconnected from the game.";
        currentState = NOT_STARTED;
        setChanged();
        notifyObservers();
    }

    /**
     * The player disconnects from the client
     */
    public void disconnect() {
        gameGrid.clearGrid();
        message = "You have disconnected from the game.";
        currentState = NOT_STARTED;
        setChanged();
        notifyObservers();
        client.disconnect();
    }

    /**
     * The player receives a move from the other player
     *
     * @param x The x coordinate of the move
     * @param y The y coordinate of the move
     */
    public void receivedMove(int x, int y) {
        gameGrid.move(x, y, gameGrid.OTHER);
        if (gameGrid.isWinner(gameGrid.OTHER)) {
            message = "Opponent won!";
            currentState = FINISHED;
        } else {
            currentState = MY_TURN;
            message = "Your turn.";
        }
        setChanged();
        notifyObservers();
    }

    public void update(Observable o, Object arg) {

        switch (client.getConnectionStatus()) {
            case GomokuClient.CLIENT:
                message = "Game started, it is your turn!";
                currentState = MY_TURN;
                break;
            case GomokuClient.SERVER:
                message = "Game started, waiting for other player...";
                currentState = OTHER_TURN;
                break;
        }
        setChanged();
        notifyObservers();


    }

}