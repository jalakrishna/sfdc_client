package com.salesforce.automation.servicelayer.SaleforceUI;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.salesforce.automation.servicelayer.LightningPageObjects.Page;
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
	 * @param testObjectId => Object ID  
	 * @param driver -> Webdriver for that instance    
	 * This method opens the detail page of the specified object in lightening view
	 * @throws Exception
	 */
	public static void openDetailPage(String testObjectId,WebDriver driver) throws Exception{
		try{ 
			UIUtilities.SwitchToLightningView(driver);
			Thread.sleep(8000);
			Page page = Page.init(driver);
			page = Page.openPage(driver, testObjectId);
			Thread.sleep(8000);
			page.openDetailTab().click();
			Thread.sleep(8000);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/** 
	 * @author ishriwastava
	 * @param testObjectId => Object ID  
	 * @param driver -> Webdriver for that instance    
	 * This method opens the edit page of the specified object in lightening view
	 * @throws Exception
	 */
	public static void openEditPage(String testObjectId,WebDriver driver) throws Exception{
		try{
			UIUtilities.SwitchToLightningView(driver);
			Page page = Page.init(driver);
			page = Page.openPage(driver, testObjectId);
            Thread.sleep(10000);          
            System.out.println("Click on Details tab");
            page.openDetailTab().click();
            Thread.sleep(8000);
            System.out.println("Click on Edit button");            
            if (isPresentAndDisplayed(page.getObjectEdit()))       	
            { 
            	page.getObjectEdit().click();
            	Thread.sleep(10000);
            }else
            {
            	page.getshowMoreAction().click();
            	Thread.sleep(3000);
            	page.getDropdownEdit().click();
            	Thread.sleep(10000);
            }                       
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static boolean isPresentAndDisplayed(final WebElement element) {
		  try {
		    return element.isDisplayed();
		  } catch (NoSuchElementException e) {
		    return false;
		  }
		}
	
}
