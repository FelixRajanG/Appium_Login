package utility;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReader 
{
	String location=".\\UserData.xlsx";
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelSheetReader() throws IOException 
	{
		wb = new XSSFWorkbook(location);
		sheet=wb.getSheetAt(0); 
	}
	
	public String readCellContent(int row,int col) 
	{
		XSSFCell cell = sheet.getRow(row).getCell(col);
		DataFormatter df = new DataFormatter();
		String formatCellValue = df.formatCellValue(cell);
		return formatCellValue;
	}
}
