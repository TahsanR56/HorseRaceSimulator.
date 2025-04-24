public class Horse {
    // old attributes
    private final String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;
    // new from gui
    private String breed;
    private String coatColor;
    private String equipment;

    public Horse(char symbol, String name, double confidence) {
        this.name = name;
        this.symbol = symbol;
        this.confidence = Math.max(0.0, Math.min(1.0, confidence));
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public void fall() {
        this.hasFallen = true;
    }

    public void moveForward() {
        if (!hasFallen) distanceTravelled++;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public boolean hasFallen() {
        return hasFallen;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = Math.max(0.0, Math.min(1.0, confidence));
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
