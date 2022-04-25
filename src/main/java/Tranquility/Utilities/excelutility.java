package Tranquility.Utilities;

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

public class excelutility {

	public ArrayList<String> getData(String testcaseName, String sheetname) throws IOException {

		ArrayList<String> ar = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\LoginCredentials.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> cell = firstrow.cellIterator();
				// To identify column through which we need to traverse
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				// once coloumn is identified then scan entire testcase coloum to identify
				// testcase row

				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cell1 = row.cellIterator();
						while (cell1.hasNext()) {
							Cell cellvalue = cell1.next();
							if (cellvalue.getCellType() == CellType.STRING) {
								ar.add(cellvalue.getStringCellValue());
							} else {
								ar.add(NumberToTextConverter.toText(cellvalue.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return ar;
	}

}
