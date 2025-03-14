//ERRORS/QUESTIONS: Why do they all say "cannot invoke method on primitive type int"
package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
    private Ship ships[];
    private Grid yourGrid;
    private Grid opponentGrid;
    // Constructor: Initialize the grids and the ships.
    public Player() {
        ships = new Ship[Constants.SHIP_LENGTHS.length];
        yourGrid = new Grid();
        opponentGrid = new Grid();
        for (int i = 0; i < Constants.SHIP_LENGTHS.length; i++){
            ships[i] = new Ship(Constants.SHIP_LENGTHS[i]);
        }
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    //This should modify set the location and direction of the ship at index index, then 
    //attempt to add it to the grid. If successful return true, if unsuccessful, return false.
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        
        ships[index].setDirection(direction);
        ships[index].setLocation(row, col);
        //Read ERRORS at top of page
        if(yourGrid.addShip(ships[index])){
            return true;
        }
        else{
            return false;
        }
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        //read ERRORS at top of page
        if(yourGrid.hasShip(row, col)){
            yourGrid.markHit(row, col);
            return true;
        }
        else{
            yourGrid.markMiss(row, col);
            return false;
        }
    }
    
    
    public Grid getMyGrid() {
        return yourGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
