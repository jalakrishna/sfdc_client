package com.salesforce.automation.servicelayer.utils;

import com.salesforce.automation.servicelayer.Exception.NonSupportedPlatformException;
import com.salesforce.automation.servicelayer.config.SupportedPlatforms;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class contains all url related utilites
 * Created by rtigulla on 6/7/17.
 */
public class UrlUtilities {

    /**
     * This method is used to check whether user is in which salesforce platform
     * @param driver
     * @return return identified supported user platform enum value
     * throws: Throws non supported platform exception if it detects unknown platforms
     */
    public static SupportedPlatforms CheckUserPlatform(WebDriver driver) throws NonSupportedPlatformException {
        String url = driver.getCurrentUrl();
        if(null != url && !url.isEmpty()) {
            if (url.contains("lightning.force.com/one/one.app"))
                return SupportedPlatforms.LIGHTNING;
            else if(url.contains("my.salesforce.com"))
                return SupportedPlatforms.CLASSIC;
            else
                throw new NonSupportedPlatformException();
        }
        return null;
    }

    public static String getServerUrlIncludingProtocol(String fullUrl) throws MalformedURLException{
        URL url = new URL(fullUrl);
        String base  = url.getAuthority();
        return fullUrl.substring(0,fullUrl.indexOf(base) + base.length());
    }
}
