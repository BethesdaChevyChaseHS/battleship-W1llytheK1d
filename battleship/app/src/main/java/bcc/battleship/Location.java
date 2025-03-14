package bcc.battleship;

public class Location {
    // Instance variables
    //does it contain a ship?
    boolean contained;
    //is the space unguessed, a hit, or a miss
    int condition;
    // Constructor. Initializes with no ship and status UNGUESSED.
    public Location() {
        contained = false;
        condition = Constants.UNGUESSED;
    }

    // Was this Location a hit?
    public boolean checkHit() {
        return condition == Constants.HIT;
    }

    // Was this location a miss?
    public boolean checkMiss() {
        return condition == Constants.MISSED;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        return condition == Constants.UNGUESSED;
        
    }
    // Mark this location as a hit.
    public void markHit() {
        condition = Constants.HIT;
    }

    // Mark this location as a miss.
    public void markMiss() {
        condition = Constants.MISSED;
    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        return contained;
    }

    // Set whether this location has a ship.
    public void setShip(boolean val) {
        contained = val;
    }

    // Set the status of this Location.
    public void setStatus(int status) {
        condition = status;
    }

    // Get the status of this Location.
    public int getStatus() {
        return condition;
    }
}
