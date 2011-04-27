package com.androidpunk;

import android.os.SystemClock;
import android.util.Log;

public class Engine extends Thread {
	
	// done = true when simulation complete
	public boolean done;
	public long lastUpdate;
	
	// Frames per second
	private int fps = 25;
	private long mspf = 1000 / fps;
	
	// Used to calculate elapsed time
	private long start;
	private long remaining;
	
	public Engine () {
		done = false;
	}

	public void fps(int fps) {
		this.fps = fps;
		this.mspf = 1000 / fps;
	}
	
	@Override
	public void run() {
		try{
			while(!done){
				start = SystemClock.elapsedRealtime();
				
				// Update subsystems
				if (AP.world != null) AP.world.update();
				
				// Store last update millis
				lastUpdate = SystemClock.elapsedRealtime();
				remaining = mspf - (lastUpdate  - start);
				if(remaining > 0) sleep(remaining);
				// else => FUCK!! running late, frame(s) dropped
			}
		} catch (InterruptedException e) {
			Log.w(AP.TAG, "Engine interrupted");
		}
	}
}
