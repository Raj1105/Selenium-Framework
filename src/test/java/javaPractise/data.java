package javaPractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data {

	public static void main(String[] args) throws IOException {
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\shekh\\eclipse-workspace\\Application_Testing\\src\\test\\resources\\download.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheetCount = wb.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {
			int row = 1;
			int row1 = -1;
			XSSFSheet sheet = wb.getSheetAt(i);
			if (sheet.getSheetName().equalsIgnoreCase("fruitData")) {
				Iterator<Row> rowCol = sheet.iterator();

				while (rowCol.hasNext()) {
					Row r = rowCol.next();
					Iterator<Cell> col = r.cellIterator();

					while (col.hasNext()) {
						Cell c = col.next();

						if (c.getCellType() == c.CELL_TYPE_STRING &&
								c.getStringCellValue().equalsIgnoreCase("apple")) {
							row1 = row ;

						}

					}
					row++;
				}
				System.out.println(row1);
			}

		}

	}
}
