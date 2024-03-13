package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The CSVReader class is responsible for reading CSV files.
 */
public class CSVReader {
    /**
     * Constructs a new CSVReader.
     */
    public CSVReader(){}
    /**
     * Checks if the file path exists and is a file.
     *
     * @param path The file path.
     * @return True if the path exists and is a file, false otherwise.
     */
    public boolean checkPath(String path) {

        File file = new File(path);

        return file.exists() && file.isFile();
    }
    /**
     * Reads a CSV file and returns its contents as a list of rows, where each row is represented as a list of fields.
     *
     * @param path      The file path.
     * @param separator The separator used in the CSV file.
     * @return The contents of the CSV file as a list of rows.
     */
    public ArrayList<ArrayList<String>> readCSV(String path,String separator) {
        ArrayList<ArrayList<String>> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {

                if(line.startsWith("\"")){
                    line = line.substring(1);
                }

                if (separator == null) {
                    throw new IllegalArgumentException("El separador no puede ser nulo");
                }

                String[] parts = splitCompound(line,separator);
                ArrayList<String> row = new ArrayList<>();

                for (int i = 0; i < parts.length; i++) {
                    String field = parts[i].trim();
                    row.add(field);
                }
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
    /**
     * Splits a compound string into its parts based on the specified separator.
     *
     * @param line      The compound string.
     * @param separator The separator used to split the string.
     * @return An array containing the parts of the compound string.
     */
    private String[] splitCompound(String line, String separator) {

        ArrayList<String> partsList = new ArrayList<>();
        String[] parts = line.split(separator);

        for (int i = 0; i < parts.length; i++) {
            partsList.add(parts[i]);
        }

        for (int i = 0; i < partsList.size(); i++) {
            if (partsList.get(i).startsWith("\"\"")) {
                if (partsList.get(i).length() >= 2) {
                    partsList.set(i, partsList.get(i).substring(2));
                    if (i + 1 < partsList.size() && partsList.get(i + 1).length() >= 2) {
                        partsList.set(i + 1, partsList.get(i + 1).substring(1));
                        partsList.set(i + 1, partsList.get(i + 1).substring(0, partsList.get(i + 1).length() - 2));
                        partsList.set(i, partsList.get(i) + ", " + partsList.get(i + 1));
                        partsList.remove(i + 1);
                    }
                }
            } else {

                if (partsList.get(i).startsWith("\"")) {
                    if (partsList.get(i).length() >= 2) {
                        partsList.set(i, partsList.get(i).substring(1));
                        if (i + 1 < partsList.size() && partsList.get(i + 1).length() >= 2) {
                            partsList.set(i + 1, partsList.get(i + 1).substring(1));
                            partsList.set(i + 1, partsList.get(i + 1).substring(0, partsList.get(i + 1).length() - 1));
                            partsList.set(i, partsList.get(i) + ", " + partsList.get(i + 1));
                            partsList.remove(i + 1);
                        }
                    }
                }

            }
        }
        return partsList.toArray(new String[0]);
    }

}
