package com.salesforce.automation.servicelayer.Exception;

import com.salesforce.automation.servicelayer.config.SupportedPlatforms;

/**
 * Created by rtigulla on 6/8/17.
 */
public class NonSupportedPlatformException extends Exception {
    public NonSupportedPlatformException(){
        super(" Platform Unidentified. Here are the supported Platform"+ java.util.Arrays.asList(SupportedPlatforms.values()));
    }
}
