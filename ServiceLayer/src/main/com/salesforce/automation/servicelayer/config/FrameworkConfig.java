package com.salesforce.automation.servicelayer.config;

import java.util.Hashtable;
import java.util.Map;

/**
 * This interface contains all the global constants required to run automation
 * Created by rtigulla on 6/8/17.
 */
public class FrameworkConfig {
    public final static String UI_TEST_URL = "https://test.salesforce.com";
    private static Hashtable<String,String> ConfigMap;

    public static Hashtable<String,String> getConfigMap(){
        if(null == ConfigMap){
            ConfigMap =  new Hashtable<String,String>();
        }
        return  ConfigMap;

    }


}
