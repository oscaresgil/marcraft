package com.spaceapps.mod;

public class SAGlobal {
	public static final String MOD_ID = "sa";
	public static final String MOD_NAME = "SPACE APPS";
	public static final String VERSION = "V 0.1";
	
	public static final String SA_Client_Proxy="com.spaceapps.mod.proxy.ClientProxy";
	public static final String SA_Common_Proxy="com.spaceapps.mod.proxy.CommonProxy";
	
	public static final SACreativeTab saCreativeTab = new SACreativeTab("saCreativeTab");
	public static int[][] worldMatrix = null;
	
	public static int X, Y, Z;
	
	public static int[][] getWorldMatrix(){
		ImageServer img = new ImageServer();
		int [][] data;
		try {
			data = img.getHeightMap(1, 1);
		} catch (Exception e){
			data = null;
		}
		return data;
	}

}
