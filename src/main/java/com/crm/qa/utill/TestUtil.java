package com.crm.qa.utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PageLoadTIMEOUT = 20; // declaring wait variable here
	public static long ImplicitWait = 10;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Startklar\\eclipse-workspace\\prac\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void SwitchToFrame() {

		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
		
	/*getTestData, reads test data from a specific sheet in an Excel file and returns it as a two-dimensional Object array
	 * /A FileInputStream is created to open the Excel file.
	 * (WorkbookFactory.create(file)) is used to load the workbook.
	 The specific sheet is fetched using book.getSheet(sheetName)
	 A two-dimensional Object[][] array, data, is initialized to store the test data.
     Rows: sheet.getLastRowNum() , Columns: sheet.getRow(0).getLastCellNum()
	 i iterates through rows starting from 1 (to skip the header row).   k iterates through all cells in the header row.
    Data is retrieved using sheet.getRow(i + 1).getCell(k).toString() and stored in the data array.
	 
		
		
		*/
		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

        
    
	}

}
