package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.BaseClass;

public class Utility extends BaseClass {
	
	public static void implictWeight() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	public Sheet getSheet(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fileinputStream = new FileInputStream(projectpath+"\\src\\main\\resources\\data\\Book2.xlsx");
		
		Sheet sh = WorkbookFactory.create(fileinputStream).getSheet(sheetName);
		
		return sh;
	}
	
	public Object getSingleData(int rowNum, int cellNum, Sheet sh) {
		
		if(sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("String"))
			return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		else
		    return sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	
	public HashMap<String, String> getAllExcelData(Sheet sh) {
		
		HashMap<String, String> hm = new HashMap<>();
		
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			int cellNum = sh.getRow(i).getLastCellNum();
			for(int j=0;j<cellNum;j++)
			{
				
				hm.put(sh.getRow(i).getCell(j).getStringCellValue(), sh.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		for(Map.Entry<String, String> map : hm.entrySet()) {
			System.out.println(map.getKey() + "" + map.getValue());
		}
		
		return hm;
	}

}
