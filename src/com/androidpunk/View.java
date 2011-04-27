package com.androidpunk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

public class View extends GLSurfaceView {

	public View(Context context) {
		super(context);
		Log.d(AP.TAG, "View(Context)");
		setRenderer(new WorldRenderer());
	}

	public View(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.d(AP.TAG, "View(Context, AttributeSet)");
		setRenderer(new WorldRenderer());
	}

}
