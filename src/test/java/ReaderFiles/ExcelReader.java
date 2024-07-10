package ReaderFiles;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public String username;
    public String password;

    public  ExcelReader(){


        try (FileInputStream file = new FileInputStream("C:\\Users\\DELL\\Sai\\CucumberFramework\\src\\test\\resources\\Excel\\TestData1.xlsx")) {
            Workbook workbook = new XSSFWorkbook(file); // Load Excel file
            Sheet sheet = workbook.getSheet("Sheet1"); // Access the sheet containing data

            Iterator<Row> iterator = sheet.iterator();
            iterator.next(); // Skip header row

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                username = currentRow.getCell(0).getStringCellValue(); // Assuming username is in column 0
                password = currentRow.getCell(1).getStringCellValue(); // Assuming password is in column 1

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
