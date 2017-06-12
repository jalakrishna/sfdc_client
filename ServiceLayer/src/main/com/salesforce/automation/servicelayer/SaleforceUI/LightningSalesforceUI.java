package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;

import com.salesforce.automation.servicelayer.LightningPageObjects.HomePage;
import com.salesforce.automation.servicelayer.LightningPageObjects.Page;
import com.salesforce.automation.servicelayer.LightningPageObjects.Page;
import com.salesforce.automation.servicelayer.LightningPageObjects.User;
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
	 * @author ishriwastava
	 * @param tabName -> Name of item to search for 
	 * @param driver -> Webdriver for that instance    
	 * This method clicks on App Launcher icon in tabs and will open a specified tab.
	 * @throws Exception
	 */
	public static void openEditPage(String testObjectId,WebDriver driver) throws Exception{
		try{
			UIUtilities.SwitchToLightningView(driver);
			String url = "/one/one.app?source=aloha#/sObject/"+testObjectId+"/view";
			Page object = Page.openObjectPage(driver, url);
            Thread.sleep(10000);          
            System.out.println("Click on Details tab");
            object.getObjectDetails().click();
            System.out.println("Click on Edit button");
            if (object.getObjectEdit().isDisplayed())
            { 
            	object.getObjectEdit().click();
            }else
            {
            	object.getshowMoreAction().click();	
            	object.getDropdownEdit().click();
            }           
            
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
