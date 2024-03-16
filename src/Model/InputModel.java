package Model;

import View.OutputView;

import java.io.File;
import java.util.ArrayList;
/**
 * The InputModel class represents the model component in the MVC pattern.
 * It provides functionality related to handling input data.
 */
public class InputModel {

    private CSVReader csvReader;

    /**
     * Constructs a new InputModel object.
     */
    public InputModel(){
        csvReader = new CSVReader();
    }


    /**
     * Reads the contents of a CSV file.
     *
     * @param path  The name of the CSV file.
     * @param separator The separator used in the CSV file.
     * @return A list of rows, where each row is represented as a list of fields.
     */
    public ArrayList<ArrayList<String>> readCsv(String path, String separator){

        return csvReader.readCSV(path,separator);

    }


}
