import java.util.*;

public class Race {
    // store all horses in a group
    private final List<Horse> horses;
    private final int raceLength;
    private final String fallSymbol = "X";
    private final double minimumMoveChance = 0.05;

    // constructor
    public Race(List<Horse> horses, int raceLength) {
        this.horses = horses;
        this.raceLength = raceLength;
    }

    // large method to hold the game loop
    public void startRace() {
        boolean raceFinished = false;
        Random random = new Random();

        // as the race is still going
        while (!raceFinished) {
            clearScreen();
            // create barriers
            System.out.println("=====================");

            raceFinished = true;
            
            // move the horses forward 
            for (Horse h : horses) {
                if (!h.hasFallen() && h.getDistanceTravelled() < raceLength) {
                    double moveChance = 0;
                    if(h.getConfidence() > 0.1){
                        moveChance = h.getConfidence();
                    }
                    else{
                        moveChance = Math.max(minimumMoveChance, h.getConfidence());
                    }
                    double fallChance = 0.01 + (moveChance * 0.1); 
                    // the horses may fall
                    if (random.nextDouble() < fallChance) {
                        h.fall();
                    } else if (random.nextDouble() < moveChance) {
                        h.moveForward();
                    }
            
                    raceFinished = false;
                }
            
                printHorseLane(h);
            }
            
            // bottom barrier
            System.out.println("=====================\n");

            // control the flow of the sim
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // find the winner horse
        Horse winner = horses.stream()
                .filter(h -> !h.hasFallen())
                .max(Comparator.comparingInt(Horse::getDistanceTravelled))
                .orElse(null);

        // adjust the winners confidence by 0.05 fixed value
        if (winner != null) {
            System.out.println("And the winner is... " + winner.getName() + "!");
            winner.setConfidence(Math.min(1.0, winner.getConfidence() + 0.05));
        } else {
            // if no winners, output to user
            System.out.println("All horses fell! No winner.");
        }
    }

    // need to draw lanes for the number of horses
    private void printHorseLane(Horse h) {
        StringBuilder lane = new StringBuilder("|");
        // if a horse falls, replace it with an X
        for (int i = 0; i < raceLength; i++) {
            if (i == h.getDistanceTravelled() && !h.hasFallen()) {
                lane.append(h.getSymbol());
            } else if (h.hasFallen() && i == h.getDistanceTravelled()) {
                lane.append(fallSymbol);
            } else {
                lane.append(" ");
            }
        }
        // write the horses name next to its lane
        lane.append("| ").append(h.getName()).append(" (Confidence: ").append(String.format("%.2f", h.getConfidence())).append(")");
        System.out.println(lane);
    }

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // if screen clearing fails, just print some newlines
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }
    
}

