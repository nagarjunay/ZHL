package com.test.automation.ZHL_MP.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	
	public static Object[][] read_excel(String Sheet_Name) throws Exception
	{
		//File obj = new File("./src/main/java/com/test/automation/Nissan/data/TestData.xlsx");
		FileInputStream fis = new FileInputStream("./src/main/java/com/test/automation/Nissan/data/TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(Sheet_Name);
		
		int row_number  = sheet.getLastRowNum();
		int column_number = sheet.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[row_number][column_number];
		wb.close();
		for(int i=0; i<row_number; i++)
		{
			for(int j=0; j<column_number; j++)
			{
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

}
