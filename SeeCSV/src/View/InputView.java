package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputView extends JFrame {

    private JTextField textField;
    private JButton jbPrint;
    public static final String BTN_PRINT = "BTN_PRINT";

    private String separator;

    String description = "<html>Hello, welcome to the View CSV program. Please follow these steps:<br><br>"
            + "Step 1: Save the CSV document inside the 'Files' folder (It's important that the document is in .csv format).<br>"
            + "Step 2: Enter the file name in the upper field; it's not necessary to include the .csv extension.<br>"
            + "Step 3: Press the button, and the table will appear.</html>";


    public InputView() {
        separator = ",";
        configureInput();
        configureWindow();

    }

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


    private void configureWindow() {
        setTitle("View CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }


    public void registerController(ActionListener controller) {
        jbPrint.addActionListener(controller);
        jbPrint.setActionCommand(BTN_PRINT);
    }

    public String getFileName() {
        return textField.getText();
    }

    public void start() {
        setVisible(true);
    }


    public String getSeparator() {
        return separator;
    }
}

