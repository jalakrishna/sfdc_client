package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.config.FrameworkConstants;

public class SalesforceUI {
	
	/**
	 * @author trungta
	 * @param tabName -> Name of item to search for
	 * @param driver -> -> Webdriver for that instance
	 * This method tests open tab functionality on either classic
	 * or lightning based on user choice
	 * @return WebDriver after successfully opening specified tab
	 * @throws Exception
	 */
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
	
	/**
	 * @author trungta
	 * @param  testUserId => User id to whom you want to view detail page
	 * @param driver -> -> Webdriver for that instance
	 * This method tests open tab functionality on either classic
	 * or lightning based on user choice
	 * @return WebDriver after successfully opening detail page for specified user
	 * @throws Exception
	 */
	public static WebDriver openDetailPage(String testUserId,WebDriver driver) throws Exception {		
		try { 
			switch (FrameworkConstants.IS_PLATFORM) {
			case "lightning" : 	LightningSalesforceUI.openDetailPage(testUserId, driver);
								break;
			case "classic" : 	ClassicSalesforceUI.openDetailPage(testUserId, driver);
								break;
			}
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
