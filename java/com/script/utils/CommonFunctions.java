package com.script.utils;

import java.io.FileInputStream;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.script.runners.MobileHandlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CommonFunctions {

	public static Logger LOGGER = Logger.getAnonymousLogger();
	public static void waitForContentToLoad(AppiumDriver<MobileElement> appiumDriver) {
		while (!MobileHandlers.isElementExists(appiumDriver,
				By.xpath("//android.widget.ImageButton[@content-desc='Back Button']"))) {
			int stopCounter = 0;
			if (stopCounter == 0) {
				stopCounter++;

			}
		}
		LOGGER.info("Content loaded successfully");
	}
	
	public String readExcel(String filePath, String sheetName, int rowIndex, int columnIndex) throws IOException {
		propDriver.setPropFilePath(filePath);
		String fileName = FileUtils.getCurrentDir() + PropertyDriver.readProp("excelName");

		File file = new File(fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			workbook = new XSSFWorkbook(inputStream);

		} else if (fileExtensionName.equals(".xls")) {

			workbook = new HSSFWorkbook(inputStream);

		}

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowIndex);

		String data = null;

		LOGGER.info(">>>>" + row.getCell(columnIndex).getCellTypeEnum());
		if (row.getCell(columnIndex).getCellTypeEnum().equals(CellType.STRING))
			data = row.getCell(columnIndex).getStringCellValue();
		else if (row.getCell(columnIndex).getCellTypeEnum().equals(CellType.NUMERIC))
			data = String.valueOf(row.getCell(columnIndex).getNumericCellValue());

		return data;

	}
}
