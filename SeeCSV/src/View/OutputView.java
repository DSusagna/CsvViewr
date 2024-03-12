package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


/**
 * The OutputView class represents the view component responsible for displaying the CSV data.
 */
public class OutputView extends JFrame {

    /**
     * Constructs a new OutputView.
     */
    public OutputView(){}

    /**
     * Displays the CSV data in a table format.
     *
     * @param rows The rows of data to display.
     * @param file The name of the CSV file being displayed.
     */
    public void printCsv(ArrayList<ArrayList<String>> rows,String file) {

        JFrame frame = new JFrame(file);

        Object[][] data = new Object[rows.size() - 1][];
        for (int i = 1; i < rows.size(); i++) {
            ArrayList<String> row = rows.get(i);
            data[i - 1] = row.toArray(new String[0]);
        }

        String[] columnNames = rows.get(0).toArray(new String[0]);

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(data, columnNames);
        table.setGridColor(Color.BLACK);
        table.setBorder(new LineBorder(Color.BLACK));

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150);
        }


        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Displays an error message indicating that the file path is incorrect.
     */
    public void errorPath() {
        JOptionPane.showMessageDialog(this,
                "Make sure the document is within the \"Files\" folder\n(.csv) extension is not necessary.",
                "Name error",
                JOptionPane.ERROR_MESSAGE);
    }
}
