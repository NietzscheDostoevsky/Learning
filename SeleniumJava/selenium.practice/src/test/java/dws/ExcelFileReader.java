package dws;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelFileReader {
    public static void main(String[] args) {
        // Get the resource path (cross-platform)
        ClassLoader classLoader = ExcelFileReader.class.getClassLoader();
        
        // Load the Excel file
        InputStream fileStream = classLoader.getResourceAsStream("login.xlsx");
        
        if (fileStream == null) {
            System.out.println("Excel file not found!");
            return;
        }

        try {
            // Open the file input stream for further processing (e.g., using Apache POI to read Excel data)
            FileInputStream excelFile = new FileInputStream(new File(fileStream.toString()));
            // Proceed with reading your Excel file (Apache POI or another library)
            System.out.println("Excel file loaded successfully!");

            // Your logic to read the excel sheet goes here...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
