package com.example.ballinhole;

import android.os.Handler;
import android.util.Log;

import java.util.Observable; 

public class Timer extends Observable {
	
	Handler handler = new Handler();
	
	private int millieseconds = 0;
	
	public void Start(){
		millieseconds = 0;
		handler.postDelayed(updateTimeThread,1);
		
	}
	public void Continue() {
		handler.postDelayed(updateTimeThread, 1);
	}
	public void Pause() {
		handler.removeCallbacks(updateTimeThread);

	}
	
	private Runnable updateTimeThread = new Runnable() {
		public void run() {
			Log.v("error", "runnable: ");
			millieseconds++;
			setChanged();
			notifyObservers();
			handler.postDelayed(updateTimeThread, 1);
			Log.v("error", "runnable: ");
		}
	};
	
	public int getMilliSeconds(){
		return millieseconds;
	}
	
	public void setMilliSeconds(int m){
		this.millieseconds = m;
	}
	
	public void setHandler(Handler handler){
		this.handler = handler;
	}
	
	
}
