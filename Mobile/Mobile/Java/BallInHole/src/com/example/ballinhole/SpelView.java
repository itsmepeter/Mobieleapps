package com.example.ballinhole;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class SpelView extends View implements SensorEventListener {
	
	private SensorManager sm;
	private Sensor accelerometer;
	private Display display;
	
	
	//initialisatie bitmaps
	private Bitmap bitmapbackground;
	private Bitmap bitmapgat;
	private Bitmap bitmapbal;
	
	

    
    //breedte - bal / 2, lengte zelfde
    private int breedte;
    private int lengte;

    
    //positie gat
    private float gatX;
    private float gatY;
   
    
    private float accelerometerX;
    private float accelerometerY;
    private float accelerometerZ;
    private long accelerometerEventTijd;
    
    private int tijdbezig;
    
    private MoveAbleObject bewegendeBal = new MoveAbleObject();
    
	public SpelView(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
		
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = mWindowManager.getDefaultDisplay();
		//initialiseer accelerometer en sensormanager
		sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		//initialiseer, bal , gat, background
        Bitmap bal = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        bitmapbal = Bitmap.createScaledBitmap(bal, bewegendeBal.getBalgrootte(), bewegendeBal.getBalgrootte(), true);
        
        Bitmap hole = BitmapFactory.decodeResource(getResources(), R.drawable.gat);
        bitmapgat = Bitmap.createScaledBitmap(hole, bewegendeBal.getGatgrootte(), bewegendeBal.getGatgrootte(), true);
        
        bitmapbackground = BitmapFactory.decodeResource(getResources(), R.drawable.background);        
	}
	
	public void startSpel() {
		sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
	}
	//stop de eventlistener
	public void stopSpel() {
		sm.unregisterListener(this);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
        	switch (display.getRotation()) {
    		case Surface.ROTATION_0:
    			accelerometerX = event.values[0];
    			accelerometerY = event.values[1];
    			break;
    		case Surface.ROTATION_90:
    			accelerometerX = -event.values[1];
    			accelerometerY = event.values[0];
    			break;
    		case Surface.ROTATION_180:
    			accelerometerX = -event.values[0];
    			accelerometerY = -event.values[1];
    			break;
    		case Surface.ROTATION_270:
    			accelerometerX = event.values[1];
    			accelerometerY = -event.values[0];

    			break;
    		}
    		accelerometerZ = event.values[2];
    		accelerometerEventTijd = event.timestamp;
        } 	
	}


	
	//initialisatie
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //
        breedte = w;
        lengte = h;
        
        //gat initialiseren
        gatX = (float) (Math.random() * (w- bewegendeBal.getGatgrootte()));
        gatY = (float) (Math.random() * (h - bewegendeBal.getGatgrootte()));
        
        //tijd nog niet gebruikt
        tijdbezig = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//eerst background tekenen
		canvas.drawBitmap(bitmapbackground, 0, 0, null);
		//daarna gat
		canvas.drawBitmap(bitmapgat, gatX, gatY, null);
		
		//checken of bal in hole is
		if(bewegendeBal.getPositieX() > gatX - 10 && bewegendeBal.getPositieX() < gatX + 10 && bewegendeBal.getPositieY() > gatY - 10 && bewegendeBal.getPositieY() < gatY + 10 ){
			//timer proberen stoppen
			Toast.makeText(this.getContext(),"Je hebt gewonnen!", Toast.LENGTH_SHORT).show();
			((MainActivity)getContext()).timer.Pause();
		} else {
			//bewegende bal positie updaten en checken op collision
	        bewegendeBal.updatePositie(accelerometerX, accelerometerY, accelerometerZ, accelerometerEventTijd);
	        bewegendeBal.Botsing(breedte, lengte, bewegendeBal.getBalgrootte());
	        
		}
		

        //bitmap van bal tekenen op positie van bewegende bal
        canvas.drawBitmap(bitmapbal, bewegendeBal.positieX, bewegendeBal.positieY, null);
        
        //laat het scherm hertekenen
        //System.out.println("spelview: "+ bewegendeBal.positieX + " " + bewegendeBal.positieY);
        invalidate();
	}	
	
	protected void resetSpel(){
		bewegendeBal.setPositieX(20);
		bewegendeBal.setPositieY(20);
		gatX = (float) (Math.random() * (breedte - bewegendeBal.getGatgrootte()));
	    gatY = (float) (Math.random() * (lengte - bewegendeBal.getGatgrootte()));
	}
	//ongebruikt
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

}
