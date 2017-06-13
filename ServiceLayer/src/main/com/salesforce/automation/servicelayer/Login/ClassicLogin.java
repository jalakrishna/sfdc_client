package com.salesforce.automation.servicelayer.Login;

import com.salesforce.automation.servicelayer.ClassicPageObjects.Page;
import com.salesforce.automation.servicelayer.Exception.NonSupportedPlatformException;
import com.salesforce.automation.servicelayer.utils.UIUtilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * The Class contains all the classic related login function
 * Created by rtigulla on 6/8/17.
 */
public class ClassicLogin {

    /**
     * The following method login into specfic user in classic view
     * @param driver => WebDriver for that instance
     * @param testUserId => User id to whom you want to login
     * @return WebDriver after successful login
     * @throws MalformedURLException
     * @throws InterruptedException
     * @throws NonSupportedPlatformException
     */
    public static WebDriver LoginAsSpecifcUser(WebDriver driver,String testUserId) throws MalformedURLException, InterruptedException, NonSupportedPlatformException {
        try{
            UIUtilities.SwitchToClassicView(driver);
            String url = testUserId + "?noredirect=1";
            Page home = Page.openPage(driver, url);
            Thread.sleep(5000);
            System.out.println("Click on Login button");
            home.getHomeLogin().click();
            Thread.sleep(5000);
            UIUtilities.SwitchToClassicView(driver);
            return driver;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    
	/**
	 * This Method logout from salesforce for the user
	 * @param driver => WebDriver for that instance
	 * @throws Exception
	 */
	public static void LogoutAsTestUser(WebDriver driver) throws Exception {
		Page page = Page.init(driver);
		try {
			page.getUserName().click();
			Thread.sleep(3000);
			page.getClassicPageLogoutOption().click();

		} catch (Exception e) {
			//Log.writeLog("Error while logout as test user","info");
			e.printStackTrace();
			throw e;
		}
	}
}
