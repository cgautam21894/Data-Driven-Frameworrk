package DataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel{
	
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
				public XSSFSheet getExcelData(String filepath,String filename) throws Exception
				{
					//Open & Read File
					File file = new File(filepath + "\\" + filename);
					FileInputStream inputstream = new FileInputStream(file);
							
					//Create Workbook,sheet & row
					workbook = new XSSFWorkbook(inputstream);
					sheet = workbook.getSheetAt(0);
					
					return sheet;
				}
				
				public String getData(XSSFSheet sheet2, int row ,int column)
				{
					String data=sheet2.getRow(row).getCell(column).getStringCellValue();
					return data;
				}
				public int rowNum(XSSFSheet sheet2)
				{
					int rows=sheet2.getLastRowNum();
					rows=rows+1;
					return rows;
					
				}

				public int colNum(XSSFSheet sheet2)
				{
					int rows=sheet2.getRow(0).getLastCellNum();
					return rows;
				}
				
				
}
