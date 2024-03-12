import Controller.MainController;
import Model.InputModel;
import View.InputView;
import View.OutputView;

import static javax.swing.SwingUtilities.*;

public class Main {

    public static void main(String[] args) {

        invokeLater(() -> {
            InputModel inputModel = new InputModel();
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            MainController controller = new MainController(inputView, inputModel,outputView);
            inputView.registerController(controller);
            inputView.start();
        });


    }
}