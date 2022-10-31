package reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.sun.tools.javac.util.List;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MyCSVReader {

    public Iterator<Object[]> readCsv(String filePath){
        ArrayList<Object[]> result = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filePath));
            String[] line;
            while ((line = reader.readNext()) != null) {
                result.add(line);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return result.iterator();
    }

    }


