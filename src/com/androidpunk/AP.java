package com.androidpunk;

import android.util.Log;

public class AP {
	
	public static String TAG = "[AndroidPunk]AP";
	
	private static World world;

	public static void world(World world) {
		Log.d(TAG, "world(World)");
		AP.world = world;
	}
	
	public static World world() {
		Log.d(TAG, "world()");
		return world;
	}

}
