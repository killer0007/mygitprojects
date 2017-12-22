package dataEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.interactions.Interaction;

public class Exceldata {
	HSSFWorkbook wb;
	HSSFSheet sheet;
public List<List<String>> getexceldata(String path, String sheetName) throws IOException {
	List<List<String>> table = new ArrayList<List<String>>();
	File file = new File(path);
	FileInputStream fis = new FileInputStream(file);
	wb = new HSSFWorkbook(fis);
	sheet = wb.getSheet(sheetName);
	Iterator<Row> rowiterator = sheet.iterator();
	while(rowiterator.hasNext()) {
		Row row = rowiterator.next();
		Iterator<Cell> celliterator = row.iterator();
		List<String> data = new ArrayList<>();
		while(celliterator.hasNext()) {
			Cell cell = celliterator.next();
			switch(cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				data.add(null);
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				data.add(String.valueOf(cell.getBooleanCellValue()));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				data.add(String.valueOf(cell.getNumericCellValue()));
				break;
			case Cell.CELL_TYPE_STRING:
			data.add(cell.getStringCellValue());
			break;
			default:
				System.out.println("invalid cell type");
			}
		}
		table.add(data);
	}
	return table;
}
}
