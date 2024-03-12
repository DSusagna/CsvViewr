package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The InputView class represents the view component in the MVC pattern.
 * It provides the graphical user interface for the user to interact with the program.
 */
public class InputView extends JFrame {

    /**
     * Constant representing the action command for printing CSV data.
     */
    public static final String BTN_PRINT = "BTN_PRINT";
    /**
     * JTextField for entering the file name.
     */
    private JTextField textField;
    /**
     * JButton for triggering the CSV printing action.
     */
    private JButton jbPrint;
    /**
     * Separator used in the CSV file.
     */
    private String separator;
    /**
     * HTML-formatted description text displayed in the InputView.
     */
    private String description = "<html>Hello, welcome to the View CSV program. Please follow these steps:<br><br>"
            + "Step 1: Save the CSV document inside the 'Files' folder (It's important that the document is in .csv format).<br>"
            + "Step 2: Enter the file name in the upper field; it's not necessary to include the .csv extension.<br>"
            + "Step 3: Press the button, and the table will appear.</html>";

    /**
     * Constructs a new InputView.
     */
    public InputView() {
        separator = ",";
        configureInput();
        configureWindow();

    }

    /**
     * Configures the input components of the view.
     */
    private void configureInput() {
        textField = new JTextField(20);
        jbPrint = new JButton("View CSV");

        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Imagen
        ImageIcon originalIcon = new ImageIcon("Resources/csv.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new EmptyBorder(20, 5, 20, 5));
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(imageLabel);

        // Input
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("File Name: "));
        inputPanel.add(textField);
        inputPanel.add(jbPrint);
        contentPanel.add(inputPanel);

        // Checkbox
        JCheckBox option1 = new JCheckBox("Separator: \" , \"",true);
        JCheckBox option2 = new JCheckBox("Separator: \" ; \"");
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        JPanel checkboxPanel = new JPanel(new FlowLayout());
        checkboxPanel.add(option1);
        checkboxPanel.add(option2);
        contentPanel.add(checkboxPanel);

        // Descripcion
        JLabel textLabel = new JLabel(description);
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(textLabel);

        add(contentPanel);

        // Listener para los JCheckBoxes
        ActionListener checkBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                    separator = ",";
                } else if (option2.isSelected()) {
                    separator = ";";
                }
            }
        };
        option1.addActionListener(checkBoxListener);
        option2.addActionListener(checkBoxListener);
    }

    /**
     * Configures the window settings.
     */
    private void configureWindow() {
        setTitle("View CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Registers a controller to handle button actions.
     *
     * @param controller The action listener for the button.
     */
    public void registerController(ActionListener controller) {
        jbPrint.addActionListener(controller);
        jbPrint.setActionCommand(BTN_PRINT);
    }

    /**
     * Retrieves the file name entered by the user.
     *
     * @return The file name entered by the user.
     */
    public String getFileName() {
        return textField.getText();
    }

    /**
     * Displays the input view.
     */
    public void start() {
        setVisible(true);
    }

    /**
     * Retrieves the selected separator.
     *
     * @return The selected separator.
     */
    public String getSeparator() {
        return separator;
    }
}

