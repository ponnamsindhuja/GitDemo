package qaclickacademy.Mavenjava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven2 {

	public ArrayList<String> getData() throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		// Identify Test cases column by scanning the entire row
		// once column is identified then scan entire test cases column to identify
		// Purchase test row
		// after you grab purchase testcase row = pull all the data of that row and feed
		// into test

		FileInputStream filepath = new FileInputStream("D:\\Selenium WorkSpace\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(filepath); // create XSSFWorkbook class
		int sheets = workbook.getNumberOfSheets(); // get number of sheets count

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("test data")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // sheet index
				Iterator<Row> rows = sheet.iterator(); // sheet equals collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator(); // rows equals collection of cells

				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell c = cells.next();
					if (c.getStringCellValue().equalsIgnoreCase("Test cases")) {
						column = k; // getting index of the Test case so that we can go to Purchase
					}

					k++;
				}

				System.out.println(column); // index of the test case is 0

				while (rows.hasNext()) {

					Row r = rows.next();
					// search for the Log in in the index 0(test case row)
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Log in")) {
						Iterator<Cell> ce = r.cellIterator(); // row is collection of cells
						while (ce.hasNext()) {
							Cell c = ce.next();
							String data = c.getStringCellValue(); // getting cell value or pulling the data
							System.out.println(data);
							a.add(data);
						}

					}

				}

			}

		}
		return a;

	}

}
