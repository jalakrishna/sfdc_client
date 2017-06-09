package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.LightningPageObjects.HomePage;
import com.salesforce.automation.servicelayer.utils.UIUtilities;

public class LightningSalesforceUI {

	/**     
	 * Open any tab in sandbox
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
}
