package com.ecommerce.reusableModules;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GetExcelData {

    /**
     * Read data from excel sheet
     * @param fileName location of the excel sheet
     * @param sheetName Sheetname within the excel
     * @return array object containing the rows/columns
     */
    public static String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = new XSSFWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);
            int totalNoOfRows = sh.getLastRowNum();
            int totalNoOfCols = sh.getRow(0).getLastCellNum();
            arrayExcelData = new String[totalNoOfRows][totalNoOfCols];


            for (int i= 1 ; i <= totalNoOfRows; i++) {
                for (int j = 0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return arrayExcelData;
    }
}
