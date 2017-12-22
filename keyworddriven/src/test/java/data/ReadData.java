package data;

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

public class ReadData {
	public List<List<String>> getdata(String path, String sheetName) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet(sheetName);
		List<List<String>> readdata = new ArrayList<List<String>>();
		Iterator<Row> rowiterator = sheet.iterator();
		while (rowiterator.hasNext()) {
			List<String> data = new ArrayList<String>();
			Row row = rowiterator.next();
			Iterator<Cell> celliterator = row.cellIterator();
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
					
				}
			}
readdata.add(data);
		}

		return readdata;
	}
}
