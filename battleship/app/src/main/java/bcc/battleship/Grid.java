//ERRORS: 1; Has a problem with one of my }, likely caused by bad return statements
//As I can see, every { has a matching }
package bcc.battleship;

public class Grid {
    private Location[][] gridArray;
    private int numHits = 0;
    private int curHits = 0;
    // Create a new Grid and initialize each Location.
    public Grid() {
        //check if there's still error here with NUM_ROWS and NUM_COLS
        gridArray = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
        for (int i = 0; i < Constants.NUM_ROWS; i++){
            for (int j = 0; j < Constants.NUM_COLS; j++){
                gridArray[i][j] = new Location();
            }
        }
    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
       gridArray[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        gridArray[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        gridArray[row][col].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return gridArray[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        //use location method
        if (gridArray[row][col].getStatus() == Constants.UNGUESSED){
            return false;
        }
        else
        {
            return true;
        }
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        gridArray[row][col].setShip(true);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return gridArray[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return gridArray[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return Constants.NUM_ROWS;
    }
    
    // Return the number of columns.
    public int numCols() {
        return Constants.NUM_COLS;
    }
    
    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        int c = s.getCol();
        int r = s.getRow();
        if (s.getDirection() == Constants.HORIZONTAL){
            for (int i = c; i < c + s.getLength(); i++){
                if(r>=0 && i>=0 && r<Constants.NUM_ROWS && i<Constants.NUM_COLS){
                    if(gridArray[r][i].hasShip()){
                        return false;
                    }
                    else{
                        setShip(r, i, true);
                    }
                }
                else{
                    return false;
                }
            }
        }
        if (s.getDirection() == Constants.VERTICAL){
            for (int i = r; i < r + s.getLength(); i++){
                if(i>=0 && c>=0 && i<Constants.NUM_ROWS && c<Constants.NUM_COLS){
                    if(gridArray[i][c].hasShip() == true){
                        return false;
                    }
                    else{
                        setShip(i, c, true);
                    }
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean allShipsSank(){
        //for (int i = 0; i < Constants.SHIP_LENGTHS.length; i++){
            //numHits = numHits + Constants.SHIP_LENGTHS[i];
        //}
        for(int c = 0; c < Constants.NUM_COLS; c++){
            for(int h = 0; h < Constants.NUM_ROWS; h++){
                if(gridArray[h][c].hasShip()){
                    if(gridArray[h][c].condition != Constants.HIT){
                        return false;
                    }
                }
                //Known: Not Location.hasShip
                //if (gridArray[h][c].getStatus() == Constants.HIT){
                    //curHits += 1;
            }
        }
        //if(curHits == numHits && curHits != 0){
            //return true;
        //}
    return true;
    }
}