package View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ExceptionDialog extends JFrame {
    private JLabel messageLabel;

    public ExceptionDialog(String errorMessage) {

        JOptionPane.showMessageDialog(this, "Exception:\n"+errorMessage,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
