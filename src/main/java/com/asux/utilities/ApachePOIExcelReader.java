package com.asux.utilities;

import com.asux.config.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcelReader extends base {  //  Class definition added

    public static String getdata(String filePath, int sheetIndex, int rowIndex, int cellIndex) {
        FileInputStream file = null;
        Workbook workbook = null;

        try {
            file = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);

            if (row == null) {
                return "Row not found";
            }

            Cell cell = row.getCell(cellIndex);
            if (cell == null) {
                return "Cell not found";
            }

            DataFormatter dataFormatter = new DataFormatter();
            
            // Handle different cell types
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    // Check if it's a Date
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date dateValue = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy"); // ✅ Updated format
                        return sdf.format(dateValue);
                    }
                    // If it's not a date, check if it's a whole number (avoid scientific notation)
                    else if (cell.getNumericCellValue() % 1 == 0) {
                        return String.valueOf((long) cell.getNumericCellValue());
                    } else {
                        return String.valueOf(cell.getNumericCellValue());
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return dataFormatter.formatCellValue(cell); // Handle formula values
                case BLANK:
                    return "";
                default:
                    return "Unknown cell type";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading Excel file";
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
