package com.spaceapps.mod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.spaceapps.mod.networking.BackgroundTask;

public class SAGlobal {
	public static final String MOD_ID = "sa";
	public static final String MOD_NAME = "SPACE APPS";
	public static final String VERSION = "V 0.1";
	
	public static final String SA_Client_Proxy="com.spaceapps.mod.proxy.ClientProxy";
	public static final String SA_Common_Proxy="com.spaceapps.mod.proxy.CommonProxy";
	
	public static final SACreativeTab saCreativeTab = new SACreativeTab("saCreativeTab");
	public static int[][] worldMatrix = null;
	public static String apiURL="http://spaceapps.onlife-app.com/";
	public static int X, Y, Z;
	
	public static int[][] getWorldMatrix(){
		ImageServer img = new ImageServer();
		int [][] data;
		int[] res=getImage();
		try {
			System.out.println("X: "+res[0]+", Y: "+res[1]);
			data = img.getHeightMap(res[0], res[1]);
			uploadImage(data,res[0],res[1]);
		} catch (Exception e){
			e.printStackTrace();
			data = null;
		}
		return data;
	}
	
	public static void init(){
		int[][] matrix=getHeightMap();
		//Check if there is a height map to load
		if(matrix!=null){
			System.out.println("Using height map");
			worldMatrix=matrix;
			
			//Run in background
			Thread thread = new BackgroundTask();
    		thread.start();
		}
		else{
			System.out.println("Generating height map");
			worldMatrix=getWorldMatrix();
		}
	}
	
	public static int[] getImage(){
		int[] res = new int[2];
		try {
			JSONObject result =makeRequest(apiURL,"{\"function\":\"get_image\"}");
			res[0]=(int)(long)(Long)result.get("x");
			res[1]=(int)(long)(Long)result.get("y");
		     // handle response here...
		 }catch (Exception ex) {
			 // handle exception here
			 System.out.println("Error en getImage");
			 ex.printStackTrace();
			 res[0]=0;
			 res[1]=0;
		 }
		return res;
	}
	
	public static int[][] getHeightMap(){
		int[][] res=null;
		try {
			JSONObject result =makeRequest(apiURL,"{\"function\":\"get_height_map\"}");
			if ((int)(long)(Long)result.get("code")==500){
				return null;
			}
			res = matrixFromJSON((JSONArray)result.get("height_map"));
			System.out.println("todo bien en la matriz");
		     // handle response here...
		 }catch (Exception ex) {
			 // handle exception here
			 System.out.println("Error en getHeightMap");
			 ex.printStackTrace();
		 }
		return res;
	}
	
	public static void uploadImage(int[][] matrix,int x,int y){
		JSONObject upload = new JSONObject();
		JSONArray xArray = new JSONArray();
		for(int i=0;i<matrix.length;i++){
			JSONArray yArray = new JSONArray();
			for(int j=0;j<matrix[i].length;j++){
				yArray.add(matrix[i][j]);
			}
			xArray.add(yArray);
		}
		upload.put("matrix", xArray);
		upload.put("function", "upload_image");
		upload.put("x", x);
		upload.put("y", y);
		JSONObject result =makeRequest(apiURL,upload+"");
	}
	
	public static int[][] matrixFromJSON(JSONArray array){
		int [][] res=null;
		for(int i=0;i<array.size();i++){
			JSONArray subArray=(JSONArray)array.get(i);
			if (i==0){
				res = new int[array.size()][subArray.size()];
			}
			for(int j=0;j<subArray.size();j++){
				res[i][j]=Integer.parseInt(subArray.get(j)+"");
			}
		}
		return res;
	}
	
	public static JSONObject makeRequest(String url,String jsonParams){
		JSONObject resultJ=null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPost request = new HttpPost(url);
		    StringEntity params =new StringEntity(jsonParams);
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);
		    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		    StringBuffer result = new StringBuffer();
		    String line = "";
		    while ((line = rd.readLine()) != null) {
		        result.append(line);
		    }
		    JSONParser parser = new JSONParser();
		    Object obj = parser.parse(result.toString());
	        resultJ = (JSONObject)obj;
		     // handle response here...
		 }catch (Exception ex) {
			 // handle exception here
			 System.out.println("Error en getImage");
			 ex.printStackTrace();
		 }
		return resultJ;
	}

}
