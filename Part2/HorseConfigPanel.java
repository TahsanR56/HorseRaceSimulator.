import javax.swing.*;
import java.awt.*;

public class HorseConfigPanel extends JPanel {
    // settings
    private static final String[] BREEDS = {"Thoroughbred", "Arabian", "Quarter Horse", "Appaloosa"};
    private static final String[] COATS = {"Black", "Brown", "Grey", "White"};
    private static final String[] SYMBOLS = {"🐎", "🦄", "♞", "♘"};
    private static final String[] EQUIPMENT = {
        "Standard Saddle", "Lightweight Shoes", "Racing Bridle", "Fancy Hat"
    };

    // ui components
    private JTextField nameField;
    private JComboBox<String> breedBox;
    private JComboBox<String> coatBox;
    private JComboBox<String> symbolBox;
    private JComboBox<String> gearBox;
    private JButton addHorseButton;
    private JButton removeHorseButton;


    public HorseConfigPanel() {
        setBorder(BorderFactory.createTitledBorder("Horse Customisation"));
        setLayout(new GridLayout(6, 2, 10, 10));

        // horse Name
        add(new JLabel("Horse Name:"));
        nameField = new JTextField("Horse 1");
        add(nameField);

        // horse breed
        add(new JLabel("Breed:"));
        breedBox = new JComboBox<>(BREEDS);
        add(breedBox);

        // horse coat Colour
        add(new JLabel("Coat Colour:"));
        coatBox = new JComboBox<>(COATS);
        add(coatBox);

        // horse symbol
        add(new JLabel("Horse Symbol:"));
        symbolBox = new JComboBox<>(SYMBOLS);
        add(symbolBox);

        // horse equipment
        add(new JLabel("Equipment:"));
        gearBox = new JComboBox<>(EQUIPMENT);
        add(gearBox);

        // add Horse Button
        addHorseButton = new JButton("Add Horse");
        add(addHorseButton);

        // remove Horse Button
        removeHorseButton = new JButton("Remove Horse");
        add(removeHorseButton);
    }

    // getters
    public String getHorseName() {
        return nameField.getText();
    }

    public String getSelectedBreed() {
        return (String) breedBox.getSelectedItem();
    }

    public String getSelectedCoat() {
        return (String) coatBox.getSelectedItem();
    }

    public String getSelectedSymbol() {
        return (String) symbolBox.getSelectedItem();
    }

    public String getSelectedGear() {
        return (String) gearBox.getSelectedItem();
    }

    public JButton getAddHorseButton() {
        return addHorseButton;
    }
    
    public JButton getRemoveHorseButton() {
        return removeHorseButton;
    }
    
}
