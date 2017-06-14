package com.salesforce.automation.servicelayer.Exception;

/**
 * Created by rtigulla on 6/14/17.
 */
public class ConfigException extends  Exception{

    public ConfigException(){
        super("Configuration Key value pair is missing in the configMap. Please add it before accessing it");
    }
}
