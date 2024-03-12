package Controller;

import Model.InputModel;
import View.InputView;
import View.OutputView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class MainController implements ActionListener {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputModel inputmodel;

    public MainController(InputView inputView, InputModel inputmodel,OutputView outputView){
        this.inputView = inputView;
        this.inputmodel = inputmodel;
        this.outputView = outputView;
    }


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

    public String addCsvExtensionIfNeeded(String fileName) {
        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }
        return "Files/" + fileName;
    }
}
