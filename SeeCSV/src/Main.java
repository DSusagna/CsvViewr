
import Controller.MainController;
import Model.InputModel;
import View.InputView;
import View.OutputView;

import static javax.swing.SwingUtilities.*;
/**
 * File: Main.java
 * ----------------
 * Description: This file contains the Main class, which serves as the main entry point of the program.
 *              It initializes the MVC components and launches the application.
 */
public class Main {
    /**
     * Initializes the MVC components and starts the application by registering the controller with the input view and starting it.
     *
     * This method creates instances of InputModel, InputView, OutputView, and MainController, then registers the controller with the input view
     * and starts the input view.
     *
     * This method utilizes SwingUtilities.invokeLater() to ensure that the initialization and execution of the GUI components are done on the Event Dispatch Thread (EDT).
     *
     * @param args The command-line arguments passed to the program (not used in this implementation).
     */
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