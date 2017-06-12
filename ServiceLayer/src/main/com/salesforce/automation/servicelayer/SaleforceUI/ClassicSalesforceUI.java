package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.ClassicPageObjects.Page;
import com.salesforce.automation.servicelayer.utils.UIUtilities;

public class ClassicSalesforceUI {

	/**  
	 * @author trungta
	 * @param tabName -> Name of item to search for
	 * @param driver ->  Webdriver for that instance
	 * Open any tab in sandbox
	 * This method clicks on + sign in tabs and will open a specified tab.
	 * @throws Exception
	 */
	public static void openTab(String tabName,WebDriver driver) throws Exception{
		try{
			UIUtilities.SwitchToClassicView(driver);
			Page page = Page.init(driver);
			Thread.sleep(5000);
			page.getHomeAllTabs().click();
			Thread.sleep(5000);
			page.getHomeOpenAnyTab(tabName, driver).click();
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/** 
	 * @author trungta
	 * @param testUserId => User id to whom you want to view detail page 
	 * @param driver -> Webdriver for that instance    
	 * This method opens the detail page for the specified user
	 * @throws Exception
	 */
	public static void openDetailPage(String testUserId,WebDriver driver) throws Exception{
		try{ 
			UIUtilities.SwitchToClassicView(driver);
			Thread.sleep(8000);
			Page.openPage(driver, testUserId);
			Thread.sleep(8000);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
