package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.base.TestBase;

public class Datadriven extends TestBase {
	static String company = "";
	private static File file = new File(projectlocation + "\\AngelCoAutomation\\Resource\\Data.xlsx");;
	private static XSSFWorkbook wb;
	private static Sheet sh;
	private static FileInputStream inputStream;

	public static void accessexcel() {
		try {

			inputStream = new FileInputStream(file);
			wb = new XSSFWorkbook(inputStream);
			sh = wb.getSheet("Sheet1");
		} catch (Exception fileNotFound) {
			System.out.println("Excel file not found");
		}

	}

	public static String companyName() {

		try {
			accessexcel();
			for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
				Row row = sh.getRow(0);
				String cellName = row.getCell(i).getStringCellValue();
				// identifying the company name column
				if (cellName.equals("Company name")) {
					for (int j = 1; j <= sh.getLastRowNum(); j++) {
						// fetching the company name
						company = sh.getRow(j).getCell(i).getStringCellValue();
						System.out.println("Company name :" + company);
					}
				}

			}

		} catch (Exception e) {
			System.out.println("Not able to read the file from excel..");
		}
		return company;
	}

	public static void writeExcel(List<WebElement> data, String fieldType) {

		try {
			accessexcel();
			for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
				Row row = sh.getRow(0);
				String cellName = row.getCell(i).getStringCellValue();
				// identifying the company name column
				if (cellName.equals(fieldType)) {
					for (int j = 1; j <= data.size(); j++) {
						String value = data.get(j - 1).getText();
						// fetching the company name
						Row rownew = sh.getRow(j);
						if (rownew == null) {
							rownew = sh.createRow(j);
						}
						Cell cell = rownew.createCell(i);
						cell.setCellValue(value);
					}
				}
			}
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(file);
			wb.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
			System.out.println("failed to write the file");
		}

	}

}
