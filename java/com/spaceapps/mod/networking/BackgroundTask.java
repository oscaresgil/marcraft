package com.spaceapps.mod.networking;

import com.spaceapps.mod.SAGlobal;

public class BackgroundTask extends Thread{
	public void run(){
		System.out.println("Processing information in background");
		SAGlobal.getWorldMatrix();
	}
}
