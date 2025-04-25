import java.awt.*;
import java.util.List;
import javax.swing.*;

public class BettingPanel extends JPanel {
    private final JComboBox<String> horseSelector;
    private final JTextField betAmountField;
    private final JButton placeBetButton;
    private final JTextArea bettingLog;

    private String selectedHorseName = "";
    private int currency = 1000;
    private int lastBetAmount = 0;
    private String lastBetHorse = "";

    public BettingPanel() {
        setBorder(BorderFactory.createTitledBorder("Virtual Betting"));
        setLayout(new BorderLayout());

        // Top controls
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        topPanel.add(new JLabel("Select Horse:"));
        horseSelector = new JComboBox<>();
        topPanel.add(horseSelector);

        topPanel.add(new JLabel("Bet Amount:"));
        betAmountField = new JTextField("100");
        topPanel.add(betAmountField);

        placeBetButton = new JButton("Place Bet");
        topPanel.add(new JLabel()); // Empty label to align the button
        topPanel.add(placeBetButton);

        add(topPanel, BorderLayout.NORTH);

        // Betting log
        bettingLog = new JTextArea();
        bettingLog.setEditable(false);
        bettingLog.setBackground(Color.WHITE);
        bettingLog.setFont(new Font("Monospaced", Font.PLAIN, 13));
        bettingLog.setText("Balance: $" + currency + "\n");

        JScrollPane scrollPane = new JScrollPane(bettingLog);
        add(scrollPane, BorderLayout.CENTER);

        // Logic
        placeBetButton.addActionListener(e -> {
            lastBetHorse = (String) horseSelector.getSelectedItem();
            try {
                lastBetAmount = Integer.parseInt(betAmountField.getText().trim());
                if (lastBetAmount > currency || lastBetAmount <= 0) {
                    JOptionPane.showMessageDialog(this, "Invalid bet amount.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    selectedHorseName = lastBetHorse;
                    bettingLog.append("Placed $" + lastBetAmount + " on " + selectedHorseName + "\n");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Called after race ends
    public void evaluateBet(String winnerName) {
        if (!lastBetHorse.isEmpty()) {
            if (winnerName != null && winnerName.equals(selectedHorseName)) {
                currency += lastBetAmount;
                bettingLog.append("✅ Won! New balance: $" + currency + "\n");
            } else {
                currency -= lastBetAmount;
                bettingLog.append("❌ Lost. New balance: $" + currency + "\n");
            }
            bettingLog.append("-----------------------------\n");
        }
    }

    public void updateHorseList(List<Horse> horses) {
        horseSelector.removeAllItems();
        for (Horse h : horses) {
            horseSelector.addItem(h.getName());
        }
    }

    public void reset() {
        selectedHorseName = "";
        lastBetHorse = "";
        lastBetAmount = 0;
    }
}
