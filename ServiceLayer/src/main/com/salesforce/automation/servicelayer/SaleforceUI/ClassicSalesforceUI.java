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
	 * @param testObjectId => Object ID  
	 * @param driver -> Webdriver for that instance    
	 * This method opens the detail page of the specified object in classic view
	 * @throws Exception
	 */
	public static void openDetailPage(String testObjectId,WebDriver driver) throws Exception{
		try{ 
			UIUtilities.SwitchToClassicView(driver);
			Thread.sleep(8000);
			Page page = Page.init(driver);
			Page.openPage(driver, testObjectId);
			Thread.sleep(8000);
			page.getObjectEdit().click();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/** 
	 * @author ishriwastava
	 * @param testObjectId => Object ID  
	 * @param driver -> Webdriver for that instance    
	 * This method opens the edit page of the specified object in classic view
	 * @throws Exception
	 */
	public static void openEditPage(String testObjectId,WebDriver driver) throws Exception{
		try{
			UIUtilities.SwitchToClassicView(driver);
			Thread.sleep(10000);
			Page page = Page.init(driver);
			Page.openPage(driver, testObjectId);    
			Thread.sleep(10000);
            System.out.println("Click on Edit button");
            page.getObjectEdit().click(); 
            Thread.sleep(8000);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
