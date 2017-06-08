package com.salesforce.automation.servicelayer.Base;

import com.sforce.cd.kumonium.extensions.webdriver.KumoniumWebDriverExtension;
import org.ehoffman.testng.extensions.Fixture;
import org.ehoffman.testing.fixture.FixtureContainer;
import org.openqa.selenium.WebDriver;

/**
 * Created by rtigulla on 6/7/17.
 * This is the Base class for all the service layer and this class contains all the reusable functionality and
 * this is the first class which needs will be executed, so that is loads all the properites required to run automation
 */
public class Base {

    /**
     * The method is leverages kumonium frameworks and provides us with the driver instance, based on the virtual paramters
     *  provided while running the maven project
     * @return a new Instance of WebDriver with all desired capabilities associated
     * @throws InterruptedException
     */
    @Fixture(factory={KumoniumWebDriverExtension.DESIRED_CAPABILITIES.class})
    public static WebDriver getNewInstanceofDriver() throws InterruptedException {
        WebDriver driver;
        try {
            System.out.println("Get Handle to WebDriver using Fixture");
            driver = FixtureContainer.getService(KumoniumWebDriverExtension.class);
            Thread.sleep(3000);
            if (driver == null) {
                System.out.println("WebDriver did not initialize Driver correctly");
                return null;
            }
        }catch (Exception ex){
            System.out.println("Exception, " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        return driver;
    }
}
