public class Horse {
    // attributes
    private final String horseName;
    private char horseSymbol;
    private int distance;
    private boolean hasFallen;
    private double horseConfidence;

    // constructor
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.horseName = horseName;
        this.horseSymbol = horseSymbol;
        setConfidence(horseConfidence);
        this.distance = 0;
        this.hasFallen = false;
    }

    // methods
    
    // flag for if the horse has fallen
    public void fall() {
        this.hasFallen = true;
    }
    // returns the horses confidence
    public double getConfidence() {
        return this.horseConfidence;
    }
    // returns the horses distance travelled
    public int getDistanceTravelled() {
        return this.distance;
    }
    // returns the horses name
    public String getName() {
        return this.horseName;
    }
    // returns the horses symbol
    public char getSymbol() {
        return this.horseSymbol;
    }
    // returns the horses position back to the start
    public void goBackToStart() {
        this.distance = 0;
        this.hasFallen = false;
    }
    // returns if the horse has fallen or not
    public boolean hasFallen() {
        return this.hasFallen;
    }
    // increments the horses position
    public void moveForward() {
        this.distance += 1;
    }

    // sets the horses confidence
    // ensures confidence is between 0 and 1
    public void setConfidence(double newConfidence) {
        if (newConfidence < 0) {
            this.horseConfidence = 0;
        } else if (newConfidence > 1) {
            this.horseConfidence = 1;
        } else {
            this.horseConfidence = newConfidence;
        }
    }
    
    // sets the horses symbol
    public void setSymbol(char newSymbol) {
        this.horseSymbol = newSymbol;
    }
}
