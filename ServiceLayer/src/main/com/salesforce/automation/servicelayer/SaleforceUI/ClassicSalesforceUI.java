package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.ClassicPageObjects.HomePage;
import com.salesforce.automation.servicelayer.utils.UIUtilities;

public class ClassicSalesforceUI {

	/**    
	 * Open any tab in sandbox
	 * This method clicks on + sign in tabs and will open a specified tab.
	 * @throws Exception
	 */
	public static void openTab(String tabName,WebDriver driver) throws Exception{
		try{
			UIUtilities.SwitchToClassicView(driver);
			HomePage homePage = HomePage.init(driver);
			Thread.sleep(5000);
			homePage.getHomeAllTabs().click();
			Thread.sleep(5000);
			homePage.setHomeOpenAnyTab(tabName, driver);
			homePage.getHomeOpenAnyTab().click();
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
