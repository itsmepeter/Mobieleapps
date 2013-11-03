package com.example.ballinhole;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements Observer {
		
	private SpelView spelView;
	Timer timer = new Timer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_main);
		spelView = (SpelView)findViewById(R.id.spelView1);
		timer.addObserver(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}	
	
	public void startSpel(View view){
		spelView.startSpel();
		timer.Start();
	}
	
	public void stopSpel(View view){
		spelView.stopSpel();
		timer.Pause();
	}
	
	public void resetSpel(View view){
		spelView.resetSpel();
		timer.Start();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		 TextView e = (TextView)findViewById(R.id.textView1);
		 e.setText(timer.getMilliSeconds()/60 + "");
		
	}
}
