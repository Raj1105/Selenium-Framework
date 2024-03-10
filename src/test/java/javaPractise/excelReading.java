package javaPractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReading {

	public static void main(String[] args) throws IOException {
		ArrayList<String> arr = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\shekh\\eclipse-workspace\\Application_Testing\\src\\test\\resources\\download.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheetCount = wb.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {
			int fcol = 0;
			int k = 0;
			XSSFSheet sheet = wb.getSheetAt(i);
			if (sheet.getSheetName().equalsIgnoreCase("fruitData")) {
				Iterator<Row> rowCol = sheet.iterator();
				Row firstRow = rowCol.next();
				Iterator<Cell> col = firstRow.cellIterator();
				while (col.hasNext()) {
					Cell c = col.next();
					// System.out.println(c.getStringCellValue());
					if (c.getStringCellValue().equalsIgnoreCase("fruit_name")) {
						fcol = k;
					}
					k++;
				}

				// Iterator<Cell> colw = r.cellIterator();
				while (rowCol.hasNext()) {
					Row r = rowCol.next();
					if (r.getCell(fcol).getStringCellValue().equalsIgnoreCase("mango")) {
						Iterator<Cell> c3 = r.cellIterator();
						while (c3.hasNext()) {
							Cell c4 = c3.next();
							if (c4.getCellType() == c4.CELL_TYPE_STRING) {
								arr.add(c4.getStringCellValue());
							} else {
								arr.add(NumberToTextConverter.toText(c4.getNumericCellValue()));
							}
						}

					}

				}
			}

		}
		System.out.println(arr);

	}
}
