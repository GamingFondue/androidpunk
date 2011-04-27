package com.androidpunk;

import android.util.Log;

public class AP {

	public static final String TAG = "AndriodPunk";

	public static World world;
	public static Engine engine;
	
	/**
	 * Initializes AndroidPunk engine
	 */
	public static void init() {
		Log.d(TAG, "init()");
		engine = new Engine();
		engine.start();
	}
	
	/**
	 * Stops AndroidPunk engine
	 */
	public static void destroy() {
		Log.d(TAG, "detroy()");
		if(engine != null && engine.isAlive()){
			engine.done = true;
		}
	}
	
}
