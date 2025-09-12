package com.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    static Workbook workbook;

    public static String getCellData(String sheetName, int rowIndex, String columnName) {
        try {
            if (workbook == null) {
                FileInputStream fis = new FileInputStream("src/test/resources/Exceldata/InputData.xlsx");
                workbook = WorkbookFactory.create(fis);
            }

            Sheet sheet = workbook.getSheet("sheet1");
            Row headerRow = sheet.getRow(0);
            int colIndex = -1;

            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                    colIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (colIndex == -1) return "";

            Row row = sheet.getRow(rowIndex);
            if (row == null) return "";

            Cell cell = row.getCell(colIndex);
            if (cell == null) return "";

            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue().trim();

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
