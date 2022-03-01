package lab4.data;

import java.util.Observable;

/**
 * @author Felix Mårtensson och Johnny Lam
 * Represents the 2-d game grid
 */

public class GameGrid extends Observable{

    int[][] gridArray;
    int INROW = 5;
    public final int EMPTY = 0;
    public final int ME = 1;
    public final int OTHER = 2;

	
	/**
	 * Constructor
	 * 
	 * @param size The width/height of the game grid
	 */
	public GameGrid(int size){
        gridArray = new int[size][size];
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size; j++) {
                gridArray[i][j]= EMPTY;
            }
        }
    }
	
	/**
	 * Reads a location of the grid
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return the value of the specified location
	 */
	public int getLocation(int x, int y){
        try {
            return gridArray[x][y];
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds, returned 0");
            return 0;
        }
    }
	
	/**
	 * Returns the size of the grid
	 * 
	 * @return the grid size
	 */
	public int getSize(){
        return gridArray.length;
    }
	
	/**
	 * Enters a move in the game grid
	 * 
	 * @param x the x position
	 * @param y the y position
	 * @param player
	 * @return true if the insertion worked, false otherwise
	 */
	public boolean move(int x, int y, int player){
        if (getLocation(x, y) == EMPTY) {
            gridArray[x][y] = player;
            setChanged();
            notifyObservers();
            return true;
        }else {
            return false;
        }
    }
	
	/**
	 * Clears the grid of pieces
	 */
	public void clearGrid(){
        for(int i = 0; i<gridArray.length; i++) {
            for(int j = 0; j<gridArray.length; j++) {
                gridArray[i][j]= EMPTY;
            }
        }
        setChanged();
        notifyObservers();
    }
	
	/**
	 * Check if a player has 5 in row
	 * 
	 * @param player the player to check for
	 * @return true if player has 5 in row, false otherwise
	 */
	public boolean isWinner(int player){
		winnerLoop:
		while (true) {
			// rows
			int rows = 1;
			for (int i = 0; i < gridArray.length; i++) {
				for (int j = 0; j < gridArray.length - 1; j++) {
					if(gridArray[i][j] == player) {
						if (gridArray[i][j] != EMPTY && (gridArray[i][j] == gridArray[i][j + 1])) {
							rows++;
						}
						if (rows == INROW) {
							break winnerLoop;
						}
					}
				}
				rows = 1;
			}
			// colums
			int colums = 1;
			for(int j = 0; j<gridArray.length; j++) {
				for (int i = 0; i < gridArray.length-1; i++) {
					if(gridArray[i][j] == player) {
						if (gridArray[i][j] != EMPTY && (gridArray[i][j] == gridArray[i + 1][j])) {
							colums++;
						}
						if (colums == INROW) {
							System.out.println(colums);
							break winnerLoop;
						}
					}
				}
				colums = 1;
			}
			// diagonal right
			//  x|0|0
			//  0|x|0
			//  0|0|x
			int diagonalR = 1;
			int newJ;
			int newI;
			for(int i = 0; i<gridArray.length-1; i++) {
				for (int j = 0; j < gridArray.length-1; j++) {
					newJ = j;
					newI = i;
					for(int a = 0; a<INROW; a++) {
						if(gridArray[i][j] == player) {
							try {
							if (gridArray[i][j] != EMPTY && (gridArray[i][j] == gridArray[i + 1][j + 1])) {
								diagonalR++;
								i++;
								j++;
							} else {
								i = newI;
								j = newJ;
								diagonalR = 1;
								break;
							}
							if (diagonalR == INROW) {
								System.out.println(diagonalR);
								break winnerLoop;

							}
							}catch(Exception ArrayIndexOutOfBoundsException) {
								i = newI;
								j = newJ;
								diagonalR = 1;
								break;
							}
						}
					}
				}

				diagonalR = 1;
			}
			// diagonal left
			//  0|0|x
			//  0|x|0
			//  x|0|0
			int diagonalL = 1;
			newJ = 0;
			newI = 0;
			for(int i = 0; i<gridArray.length; i++) {
				for (int j = gridArray.length-1; j > 0; j--) {
					newJ = j;
					newI = i;
					for(int a = 0; a<INROW; a++) {
						if(gridArray[i][j] == player) {
							try {
								if (gridArray[i][j] != EMPTY && (gridArray[i][j] == gridArray[i + 1][j - 1])) {
									diagonalL++;
									i++;
									j--;
								} else {
									i = newI;
									j = newJ;
									diagonalL = 1;
									break;
								}
								if (diagonalL == INROW) {
									System.out.println(diagonalL);
									break winnerLoop;

								}
							}catch(Exception ArrayIndexOutOfBoundsException) {
								i = newI;
								j = newJ;
								diagonalL = 1;
								break;
							}
						}
					}
				}

				diagonalL = 1;
			}
			return false;

		}
		return true;
    }
	
	
}