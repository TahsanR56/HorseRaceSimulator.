import java.awt.*;
import java.util.List;
import javax.swing.*;

public class HorseRaceGUI extends JFrame {
    private final List<Horse> horses = new java.util.ArrayList<>();

    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 700;
    private static final String WINDOW_TITLE = "Horse Race Simulator";

    private final TrackConfigPanel trackConfigPanel;
    private final HorseConfigPanel horseConfigPanel;
    private final RaceArenaPanel raceArenaPanel;
    private final StatisticsPanel statisticsPanel;
    private final BettingPanel bettingPanel;

    public HorseRaceGUI() {
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // initialise panels
        trackConfigPanel = new TrackConfigPanel();
        horseConfigPanel = new HorseConfigPanel();
        raceArenaPanel = new RaceArenaPanel();
        statisticsPanel = new StatisticsPanel();
        bettingPanel = new BettingPanel();

        // left panel: track & horse configuration
        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
        leftPanel.add(trackConfigPanel);
        leftPanel.add(horseConfigPanel);

        // right panel: statistics & betting
        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
        rightPanel.add(statisticsPanel);
        rightPanel.add(bettingPanel);

        // add panels to layout
        add(leftPanel, BorderLayout.WEST);
        add(raceArenaPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        // start button
        JButton startButton = new JButton("Start Race");
        startButton.addActionListener(e -> new Thread(this::runTextRace).start());
        add(startButton, BorderLayout.SOUTH);

        // add horses
        horseConfigPanel.getAddHorseButton().addActionListener(e -> {
            Horse horse = new Horse(
                horseConfigPanel.getSelectedSymbol().charAt(0),
                horseConfigPanel.getHorseName(),
                Math.random() * 0.5 + 0.5
            );
            horse.setBreed(horseConfigPanel.getSelectedBreed());
            horse.setCoatColor(horseConfigPanel.getSelectedCoat());
            horse.setEquipment(horseConfigPanel.getSelectedGear());

            horses.add(horse);
            raceArenaPanel.appendRaceLine("Added horse: " + horse.getName());
            bettingPanel.updateHorseList(horses); // update betting dropdown
        });

        // final 
        setVisible(true);
    }

    private void runTextRace() {
        int trackLength = trackConfigPanel.getTrackLength();
        raceArenaPanel.clearDisplay();
        statisticsPanel.clearStats();

        boolean finished = false;
        int timeSteps = 0;

        while (!finished) {
            timeSteps++;
            finished = true;
            StringBuilder frame = new StringBuilder();

            for (Horse h : horses) {
                if (!h.hasFallen() && h.getDistanceTravelled() < trackLength) {
                    double moveChance = h.getConfidence();
                    double fallChance = 0.02 + (moveChance * 0.1);

                    if (Math.random() < fallChance) {
                        h.fall();
                    } else if (Math.random() < moveChance) {
                        h.moveForward();
                    }
                    finished = false;
                }

                StringBuilder lane = new StringBuilder("|");
                for (int i = 0; i < trackLength; i++) {
                    if (i == h.getDistanceTravelled() && !h.hasFallen()) {
                        lane.append(h.getSymbol());
                    } else if (h.hasFallen() && i == h.getDistanceTravelled()) {
                        lane.append("X");
                    } else {
                        lane.append(" ");
                    }
                }
                lane.append("| ").append(h.getName());
                frame.append(lane).append("\n");
            }

            raceArenaPanel.updateRaceDisplay(frame.toString());

            try {
                Thread.sleep(250);
            } catch (InterruptedException ignored) {}
        }

        // determine winner
        Horse winner = horses.stream()
            .filter(h -> !h.hasFallen())
            .max(java.util.Comparator.comparingInt(Horse::getDistanceTravelled))
            .orElse(null);

        if (winner != null) {
            JOptionPane.showMessageDialog(this, "Winner: " + winner.getName());
        } else {
            JOptionPane.showMessageDialog(this, "All horses fell! No winner.");
        }

        // update stats
        for (Horse h : horses) {
            statisticsPanel.showStatsForHorse(h, timeSteps);
        }

        // reset horese
        horses.forEach(Horse::goBackToStart);
    }
}
