package Model;

import java.util.ArrayList;

public class InputModel {

    private CSVReader csvReader;

    public InputModel(){
        csvReader = new CSVReader();
    }

    public boolean checkPath(String path){
        return csvReader.checkPath(path);
    }

    public ArrayList<ArrayList<String>> readCsv(String fileName,String separator){
        return csvReader.readCSV(fileName,separator);
    }


}
