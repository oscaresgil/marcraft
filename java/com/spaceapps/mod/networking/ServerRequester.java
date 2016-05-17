package com.spaceapps.mod.networking;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class ServerRequester {
	public void init(){
		HttpClient httpClient = HttpClientBuilder.create().build();
		 try {
		        HttpPost request = new HttpPost("http://spaceapps.onlife-app.com/");
		        StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
		        request.addHeader("content-type", "application/x-www-form-urlencoded");
		        request.setEntity(params);
		        HttpResponse response = httpClient.execute(request);
		        System.out.println(response);
		        // handle response here...
		    }catch (Exception ex) {
		        // handle exception here
		    }
	}
}
