package com.salesforce.automation.servicelayer.Login;

import com.salesforce.automation.servicelayer.Base.Base;
import com.salesforce.automation.servicelayer.Exception.DriverNotFoundException;
import com.salesforce.automation.servicelayer.ClassicPageObjects.SFLogin;
import com.salesforce.automation.servicelayer.config.FrameworkConstants;
import org.openqa.selenium.WebDriver;

/**
 * This Login class contains all the login related functionality
 * Created by rtigulla on 6/8/17.
 */
public class Login extends Base{
    private static final String loginUrl = FrameworkConstants.UI_TEST_URL;

    /**
     * The method is used to login to platform
      * @return WebDriver after successful login.
     * @throws InterruptedException
     * @throws DriverNotFoundException
     */
    public static WebDriver Login() throws InterruptedException, DriverNotFoundException {
        WebDriver driver;
        try {
            driver = getNewInstanceofDriver();
            if (null != driver) {
                System.out.println("Go to salesforce.com");
                driver.get(loginUrl);
                Thread.sleep(4000);
                System.out.println("Page title is: " + driver.getTitle());
                System.out.println("Enter username");
                SFLogin sfLogin = SFLogin.init(driver);
                sfLogin.getUserName().sendKeys("rtigulla@salesforce.com.csgqa1");
                Thread.sleep(4000);
                System.out.println("Enter password");
                sfLogin.getPassword().sendKeys("Work@sfdc009");
                Thread.sleep(4000);
                sfLogin.getLoginBtn().click();
                Thread.sleep(4000);
            } else {
                throw new DriverNotFoundException();
            }
        }catch (Exception ex){
            System.out.println("Exception, " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        return driver;

    }

    public static WebDriver LoginAsTestUser(WebDriver driver, String userId){
        try{
            if (null != driver){
                switch (FrameworkConstants.IS_PLATFORM){
                    case "classic": ClassicLogin.LoginAsSpecifcUser(driver,userId);
                                    break;
                    case "lightning": LightningLogin.LoginAsSpecifcUser(driver,userId);
                                    break;
                }
            }
        }catch (Exception ex){

        }
        return driver;
    }

}
