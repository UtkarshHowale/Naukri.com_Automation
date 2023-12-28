package org.Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider {


    @Test
    public void DataProvider() throws IOException {

            File file = new File("E:\\Intellj Workspace\\Naukari.com\\src\\test\\resources\\TestData.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int NumberOfRows = sheet.getLastRowNum();
            int NumberOfColumns = sheet.getRow(1).getLastCellNum();

            for (int row = 0;row<=NumberOfRows;row++){

                XSSFRow Row = sheet.getRow(row);

                for (int col=0;col<NumberOfColumns;col++){

                    XSSFCell Cell = Row.getCell(col);

                    switch (Cell.getCellType()){

                        case STRING:
                            System.out.println(Cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            System.out.println(Cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            System.out.println(Cell.getBooleanCellValue());
                            break;
                    }
                }
                System.out.println();
            }
    }
}
