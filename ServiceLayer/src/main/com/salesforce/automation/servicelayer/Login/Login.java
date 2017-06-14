package com.salesforce.automation.servicelayer.Login;

import com.salesforce.automation.servicelayer.Base.Base;
import com.salesforce.automation.servicelayer.Exception.ConfigException;
import com.salesforce.automation.servicelayer.Exception.DriverNotFoundException;
import com.salesforce.automation.servicelayer.ClassicPageObjects.SFLogin;
import com.salesforce.automation.servicelayer.config.FrameworkConfig;
import org.openqa.selenium.WebDriver;

/**
 * This Login class contains all the login related functionality
 * Created by rtigulla on 6/8/17.
 */
public class Login extends Base{
    private static final String loginUrl = FrameworkConfig.UI_TEST_URL;

    /**
     * The method is used to login to platform
      * @return WebDriver after successful login.
     * @throws InterruptedException
     * @throws DriverNotFoundException
     */
    public static WebDriver Login() throws InterruptedException, DriverNotFoundException, ConfigException {
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
                if(FrameworkConfig.getConfigMap().containsKey("USERNAME"))
                    sfLogin.getUserName().sendKeys(FrameworkConfig.getConfigMap().get("USERNAME"));
                else
                    throw new ConfigException();
                Thread.sleep(4000);
                System.out.println("Enter password");
                if(FrameworkConfig.getConfigMap().containsKey("PASSWORD"))
                    sfLogin.getPassword().sendKeys(FrameworkConfig.getConfigMap().get("PASSWORD"));
                else
                    throw new ConfigException();
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
                 if (FrameworkConfig.getConfigMap().containsKey("IS_PLATFORM")) {
                     switch (FrameworkConfig.getConfigMap().get("IS_PLATFORM")) {
                         case "classic":
                             ClassicLogin.LoginAsSpecifcUser(driver, userId);
                             break;
                         case "lightning":
                             LightningLogin.LoginAsSpecifcUser(driver, userId);
                             break;
                     }
                 }else{
                     throw new ConfigException();
                 }
            }
        }catch (Exception ex){

        }
        return driver;
    }
    
	/**
	 * This Method is used to logout from Lightning/Classic salesforce for selected user
     * @throws Exception
	 */
	public static void LogoutAsTestUser(WebDriver driver) throws Exception {		
		try {
			if(null != driver){
                if (FrameworkConfig.getConfigMap().containsKey("IS_PLATFORM")) {
                    switch (FrameworkConfig.getConfigMap().get("IS_PLATFORM")) {
                        case "classic":
                            ClassicLogin.LogoutAsTestUser(driver);
                            break;
                        case "lightning":
                            LightningLogin.LogoutAsTestUser(driver);
                            break;
                    }
                }else{
                    throw new ConfigException();
                }
			}
			
		} catch (Exception e) {
			System.out.println("Error while logout as test user");
			e.printStackTrace();
			throw e;
		}
	}

}
