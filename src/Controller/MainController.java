package Controller;

import Model.InputModel;
import View.InputView;
import View.OutputView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
/**
 * The MainController class serves as the controller in the MVC pattern.
 * It handles user actions from the InputView and interacts with the InputModel and OutputView accordingly.
 */
public class MainController implements ActionListener {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputModel inputmodel;

    /**
     * Constructs a MainController with references to the InputView, InputModel, and OutputView.
     *
     * @param inputView   The input view component.
     * @param inputmodel  The input model component.
     * @param outputView  The output view component.
     */
    public MainController(InputView inputView, InputModel inputmodel,OutputView outputView){
        this.inputView = inputView;
        this.inputmodel = inputmodel;
        this.outputView = outputView;
    }

    /**
     * Invoked when an action occurs.
     * Handles the action event from the input view.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case InputView.BTN_PRINT:

                String path = addCsvExtensionIfNeeded(inputView.getFileName());


                if(inputmodel.checkPath(path)){
                    outputView.printCsv(inputmodel.readCsv(path,inputView.getSeparator()),path);
                } else {
                    outputView.errorPath();
                }

                break;
            default:
                System.err.println("Unknown action command " + e.getActionCommand());
        }

    }

    /**
     * Adds the ".csv" extension to the file name if it's missing.
     *
     * @param fileName The file name.
     * @return The file name with the ".csv" extension added if needed.
     */
    public String addCsvExtensionIfNeeded(String fileName) {
        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }
        //return "CsvViewrProject/Files/" + fileName;
        return fileName;
    }
}
