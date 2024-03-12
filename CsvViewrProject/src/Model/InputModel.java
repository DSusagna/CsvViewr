package Model;

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
     * Checks if the specified file path exists and is a file.
     *
     * @param path The file path to check.
     * @return True if the path exists and is a file, false otherwise.
     */
    public boolean checkPath(String path){
        return csvReader.checkPath(path);
    }

    /**
     * Reads the contents of a CSV file.
     *
     * @param fileName  The name of the CSV file.
     * @param separator The separator used in the CSV file.
     * @return A list of rows, where each row is represented as a list of fields.
     */
    public ArrayList<ArrayList<String>> readCsv(String fileName,String separator){
        return csvReader.readCSV(fileName,separator);
    }


}
