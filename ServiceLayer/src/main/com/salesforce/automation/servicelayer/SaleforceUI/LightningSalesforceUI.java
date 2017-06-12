package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.LightningPageObjects.HomePage;
import com.salesforce.automation.servicelayer.utils.UIUtilities;

public class LightningSalesforceUI {

	/** 
	 * @author trungta
	 * @param tabName -> Name of item to search for 
	 * @param driver -> Webdriver for that instance    
	 * This method clicks on App Launcher icon in tabs and will open a specified tab.
	 * @throws Exception
	 */
	public static void openTab(String tabName,WebDriver driver) throws Exception{
		try{
			UIUtilities.SwitchToLightningView(driver);
			HomePage homePage = HomePage.init(driver);
			Thread.sleep(8000);
			homePage.getAppLauncher().click();
			Thread.sleep(8000);
			homePage.setHomeOpenAnyTab().sendKeys(tabName);
			Thread.sleep(8000);
			homePage.getSearchItem(tabName).click();
			Thread.sleep(8000);
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
			UIUtilities.SwitchToLightningView(driver);
			HomePage homePage = HomePage.init(driver);
			Thread.sleep(8000);
			homePage = homePage.openUserAccountPage(driver, testUserId);
			Thread.sleep(8000);
			homePage.openAccountDetailPage().click();
			Thread.sleep(8000);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
