package com.salesforce.automation.servicelayer.Login;

import com.salesforce.automation.servicelayer.Exception.NonSupportedPlatformException;
import com.salesforce.automation.servicelayer.LightningPageObjects.User;
import com.salesforce.automation.servicelayer.utils.UIUtilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * The Class contains all the lightning related login function
 * Created by rtigulla on 6/8/17.
 */
public class LightningLogin {

    /**
     * The following method login into specfic user in Lightning view
     * @param driver => WebDriver for that instance
     * @param testUserId => User id to whom you want to login
     * @return WebDriver after successful login
     * @throws MalformedURLException
     * @throws InterruptedException
     * @throws NonSupportedPlatformException
     */
    public static WebDriver LoginAsSpecifcUser(WebDriver driver, String testUserId) throws MalformedURLException, InterruptedException, NonSupportedPlatformException {
        try{
            UIUtilities.SwitchToLightningView(driver);
            String url = "/one/one.app?source=aloha#/sObject/"+testUserId+"/view";
            User user = User.openUserPage(driver, url);
            Thread.sleep(10000);
            System.out.println("Click on Login button");
            user.getUserDetail().click();
            Thread.sleep(10000);
            System.out.println("Switch to Iframe");
            driver.switchTo().frame(user.getUserDetailsIframe());
            Thread.sleep(3000);
            System.out.println("Click on the login button");
            user.getUserLogin().click();
            Thread.sleep(6000);
            UIUtilities.SwitchToLightningView(driver);
            return driver;
        }catch(Exception e){
            //Log.writeLog("Error while login as test user","info");
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
	 * This Method is used to logout from lightning salesforce for the user
	 * @param driver => WebDriver for that instance
	 * @throws Exception
	 */
	public static void LogoutAsTestUser(WebDriver driver) throws Exception {
		try {
			com.salesforce.automation.servicelayer.LightningPageObjects.Page page = com.salesforce.automation.servicelayer.LightningPageObjects.Page.init(driver);
			page.getUserIcon().click();
			Thread.sleep(3000);
			page.getLightningPageLogoutOption().click();

		} catch (Exception e) {
			//Log.writeLog("Error while logout as test user","info");
			e.printStackTrace();
			throw e;
		}
	}
}
