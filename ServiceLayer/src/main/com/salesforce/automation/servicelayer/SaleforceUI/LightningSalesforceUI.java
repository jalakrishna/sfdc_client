package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.WebDriver;
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
			Page homePage = Page.init(driver);
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
			Thread.sleep(8000);
			User user = User.init(driver);
			user = User.openUserPage(driver, testUserId);
			Thread.sleep(8000);
			user.openDetailTab().click();
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
			//String url = "/one/one.app?source=aloha#/sObject/"+testObjectId+"/view";
			User user = User.init(driver);
			user = User.openUserPage(driver, testObjectId);
            Thread.sleep(10000);          
            System.out.println("Click on Details tab");
            user.openDetailTab().click();
            Thread.sleep(8000);
            System.out.println("Click on Edit button");
            if (user.getObjectEdit().isDisplayed())
            { 
            	user.getObjectEdit().click();
            }else
            {
            	user.getshowMoreAction().click();
            	Thread.sleep(3000);
            	user.getDropdownEdit().click();
            	Thread.sleep(8000);
            }                       
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
