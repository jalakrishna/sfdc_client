package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.config.FrameworkConstants;

public class SalesforceUI {
	
	public static WebDriver openTab(String tabName,WebDriver driver) throws Exception {		
		try { 
			switch (FrameworkConstants.IS_PLATFORM) {
			case "lightning" : 	LightningSalesforceUI.openTab(tabName, driver);
								break;
			case "classic" : 	ClassicSalesforceUI.openTab(tabName, driver);
								break;
			}
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
