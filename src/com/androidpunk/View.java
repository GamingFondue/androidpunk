package com.androidpunk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

public class View extends GLSurfaceView {

	public static String TAG = "[AndroidPunk]View";
	
	private WorldRenderer renderer;

	public View(Context context) {
		super(context);
		Log.d(TAG, "View(Context)");
		renderer = new WorldRenderer();
		setRenderer(renderer);
	}

	public View(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(TAG, "View(Context, AttributeSet)");
		renderer = new WorldRenderer();
		setRenderer(renderer);
	}

}
