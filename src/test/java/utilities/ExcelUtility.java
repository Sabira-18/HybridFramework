package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    XSSFWorkbook workbook;
    Sheet sheet;

    public ExcelUtility(String filepath) throws IOException {

        File file = new File(filepath);
        FileInputStream fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
    }

    public String readDataFromExcel(String sheetName, int rowIndex, int columnIndex) {

        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(columnIndex);

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
    public Object[][] getSheetData(String sheetName)
    {
    	sheet = workbook.getSheet(sheetName);
    	int totalRows= sheet.getLastRowNum();
    	int totalCols = sheet.getRow(0).getLastCellNum();
    	Object[][] data = new Object[totalRows][totalCols];
    	for (int i=1;i<=totalRows;i++)
    	{
    		for(int j=0;j<totalCols;j++)
    		{
    			DataFormatter formatter = new DataFormatter();
    			data[i-1][j]= formatter.formatCellValue(sheet.getRow(i).getCell(j));
    		}
    	}
    	return data;
    }
}