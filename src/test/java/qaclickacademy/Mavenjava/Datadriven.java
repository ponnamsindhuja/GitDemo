package qaclickacademy.Mavenjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {

		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\Selenium WorkSpace\\demodata.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("test data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Test cases column by scanning the entire row
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstrow = rows.next();

				Iterator<Cell> cells = firstrow.cellIterator(); // row is collection of cells

				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell cell = cells.next();
					if (cell.getStringCellValue().equalsIgnoreCase("test cases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				// once column is identified then scan entire test cases column to identify
				// Purchase test row
				while (rows.hasNext()) {

					Row rs = rows.next();
					if (rs.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						// after you grab purchase testcase row = pull all the data of that row and feed
						// into test
						Iterator<Cell> ci = rs.cellIterator();
						while (ci.hasNext()) {

							Cell eachcell = ci.next();

							if (eachcell.getCellType() == CellType.STRING) {
								String data = eachcell.getStringCellValue();
								System.out.println(data);
								a.add(data);
							} else {
								a.add((NumberToTextConverter.toText(eachcell.getNumericCellValue())));

							}
						}

					}
				}
			}

		}
		return a;
	}

	public static void main(String[] args) throws IOException {

		/*
		 * Datadriven d = new Datadriven(); ArrayList<String> data =
		 * d.getData("Purchase"); System.out.println(data.get(0));
		 * System.out.println(data.get(1)); System.out.println(data.get(2));
		 * System.out.println(data.get(3));
		 */

	}

}
