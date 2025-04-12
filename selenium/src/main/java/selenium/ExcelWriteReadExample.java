package selenium;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelWriteReadExample {

    // File path for the Excel file
    static String filePath = "ContactData.xlsx";

    public static void main(String[] args) {
        writeExcel();   // Step 1: Write to Excel
        readExcel();    // Step 2: Read from Excel
    }

    // Method to write data into Excel file
    public static void writeExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // Data to be written
        String[][] data = {
                {"Name", "Age", "Email"},
                {"John Doe", "30", "john@test"},
                {"Jane Doe", "28", "jane@test"},
                {"Bob Smith", "35", "jacky@example"},
                {"Swapnil", "37", "swapnil@example"}
        };

        // Create a bold style for header
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // Populate rows
        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);

                // Apply bold style to header
                if (i == 0) {
                    cell.setCellStyle(headerStyle);
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < data[0].length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the data to file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            System.out.println("Excel file written successfully to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close(); // Ensure workbook is closed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to read data from Excel file
    public static void readExcel() {
        System.out.println("\nReading from Excel file:\n");

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print((int) cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("?\t");
                            break;
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
