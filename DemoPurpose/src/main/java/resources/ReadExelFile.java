package resources;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExelFile {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public XSSFRow row = null;

	public ReadExelFile(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public XSSFSheet getSheet(int sheetnumber) {
		
		sheet = wb.getSheetAt(sheetnumber);
		return sheet;
		
	}

	public String getData(int sheetnumber, int row, int column) {
		sheet = wb.getSheetAt(sheetnumber);
		Cell cell1 = sheet.getRow(row).getCell(column);

		String data = null;
		switch (cell1.getCellType()) {

		case HSSFCell.CELL_TYPE_STRING:
			data = sheet.getRow(row).getCell(column).getStringCellValue();
			break;

		case HSSFCell.CELL_TYPE_NUMERIC:
			data = String.valueOf(sheet.getRow(row).getCell(column).getNumericCellValue());
			break;

		}
		return data;
	}

	public int getRowCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}

	public int getColumnCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

}
