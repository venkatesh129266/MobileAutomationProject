package com.script.android;


public class TestBase {

	
	public static String technology = null;
    public static String whiteLabel = null;
    
    public static void setWhiteLabel(String whiteLabel) {
    	TestBase.whiteLabel=whiteLabel;
    }
    
    public static String getWhiteLabel() {
        // TODO Auto-generated method stub
        return whiteLabel;
    }
    
    public static void setTechnology(String technology) {	
    	TestBase.technology = technology;
    }

    public static String getTechnology() {
        return technology;    }
	
}