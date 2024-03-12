package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public CSVReader(){}

    public boolean checkPath(String path) {

        File file = new File(path);
        return file.exists() && file.isFile();
    }

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
