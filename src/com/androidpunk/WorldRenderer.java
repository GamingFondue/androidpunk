package com.androidpunk;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.SystemClock;
import android.util.Log;

public class WorldRenderer implements Renderer {
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		Log.d(AP.TAG, "onSurfaceCreated(GL10, EGLConfig)");
		
		// Set the background color to black ( rgba ).
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		// Enable Smooth Shading, default not really needed.
		gl.glShadeModel(GL10.GL_SMOOTH);
		
		// Depth buffer setup.
		gl.glClearDepthf(1.0f);
		
		// Enables depth testing.
		gl.glEnable(GL10.GL_DEPTH_TEST);
		
		// The type of depth testing to do.
		gl.glDepthFunc(GL10.GL_LEQUAL);

		// Really nice perspective calculations.
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		if(AP.world != null) {
			AP.world.render(SystemClock.elapsedRealtime() - AP.engine.lastUpdate);
		}
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		Log.d(AP.TAG, "onSurfaceChanged(GL10, int, int)");
		
		// Sets the current view port to the new size.
		gl.glViewport(0, 0, width, height);
		
		// Select the projection matrix
		gl.glMatrixMode(GL10.GL_PROJECTION);

		// Reset the projection matrix
		gl.glLoadIdentity();
		
		// Orthogonal perspective
		GLU.gluOrtho2D(gl, 0, width, height, 0);
		
		// Select the modelview matrix
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		// Reset the modelview matrix
		gl.glLoadIdentity();
	}
}
