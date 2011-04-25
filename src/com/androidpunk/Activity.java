package com.androidpunk;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Activities are single, focused things user can do.
 * AndroidPunk games are activities that run as full-screen windows.
 * 
 * This class is responsible of setting up the environment, detecting device 
 * capabilities and initializing AP singleton with that information.
 * 
 * @author gamingfondue
 */
public class Activity extends android.app.Activity {
	
	public static String TAG = "[AndroidPunk]Activity";
	
	/**
	 * Begins game lifecycle. 
	 * Global state setup.
	 * AP facade initialization.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate(Bundle)");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		// TODO: initialize AP singleton
		// TODO: detect device capabilities: screen-size, OpenGL version, etc...
	}
	
	/**
	 * Visibility lifecycle
	 */
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart()");
	};
	
	/**
	 * Called after your activity has been stopped, prior to it being started again.
	 */
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart()");
	}
	
	/**
	 * Foreground lifecycle
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause()");
		// TODO: Free allocated resources
	}
	
	/**
	 * Foreground lifecycle
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume()");
	}
	
	/**
	 * Visibility lifecycle
	 */
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop()");
	};
	
	/**
	 * Global state destroy.
	 * AP facade cleanup.
	 * End of game lifecycle. 
	 */
	protected void onDestroy() {
		Log.d(TAG, "onDestroy()");
		super.onDestroy();
	};
	
}
