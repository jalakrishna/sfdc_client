package com.salesforce.automation.servicelayer.Exception;

/**
 * This is the custom exception used for handling no driver instances
 * Created by rtigulla on 6/8/17.
 */
public class DriverNotFoundException extends Exception {
    public DriverNotFoundException(){
        super("Driver was not found with required parameters: Please make Driver parameters are right");
    }
}
