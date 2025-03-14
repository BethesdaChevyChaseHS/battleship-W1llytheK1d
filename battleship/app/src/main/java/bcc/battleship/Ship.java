package bcc.battleship;

public class Ship {
    //instance variables
    int row;
    int col;
    int length;
    int direction;
    // Constructor. Create a ship and set the length.
    public Ship(int length) {
        row = Constants.UNSET;
        col = Constants.UNSET;
        direction = Constants.UNSET;
        this.length = length;
       // Ship ship1 = new Ship(row, col, length, direction);
    }
    // Has the location been initialized
    public boolean isLocationSet() {
        if(row == Constants.UNSET || col == Constants.UNSET){
            return false;
        }
        return true;
    }

    // Has the direction been initialized
    public boolean isDirectionSet() {
        if(direction == Constants.UNSET){
            return false;
        }
        return true;
    }

    // Set the location of the ship
    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Set the direction of the ship
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Getter for the row value
    public int getRow() {
        return row;
    }

    // Getter for the column value
    public int getCol() {
        return col;
    }

    // Getter for the length of the ship
    public int getLength() {
        return length;
    }

    // Getter for the direction
    public int getDirection() {
        return direction;
    }

    // Helper method to get a string value from the direction
    // Helper method to get a string value from the direction
    private String directionToString() {
        if (direction == Constants.HORIZONTAL){
            return "horizontal";
        }
        if (direction == Constants.VERTICAL){
            return "vertical";
        }
        else{
            return "unset direction";
        }
    }

    // Helper method to get a (row, col) string value from the location
    private String locationToString() {
        if (row != Constants.UNSET || col != Constants.UNSET){
            return "(" + row + ", " + col + ")";
        }
        else{
            return "(unset location)";
        }
    }

    // toString value for this Ship
    @Override
    public String toString() {
        return directionToString() + " ship of length " + length + " at " + locationToString();
    }
}