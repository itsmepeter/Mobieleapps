package com.example.drawfree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class DrawingPanel extends View {
	private Path drawPath = new Path(); 
	private Paint drawPaint = new Paint();
	//canvas 
	private Canvas drawCanvas; 
	//canvas bitmap 
	private Bitmap canvasBitmap; 
	private int c = Color.BLACK;
	private int oudekleur = Color.BLACK;

	
	public DrawingPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// is called on creation with old values 0 and 0
		super.onSizeChanged(w, h, oldw, oldh);
		canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888); 
		drawCanvas = new Canvas(canvasBitmap); 
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		drawPaint.setColor(c); 
		drawPaint.setAntiAlias(true); 
		drawPaint.setStrokeWidth(5); /*a width–int: 20 for drawing, 40 for erasing*/
		drawPaint.setStyle(Paint.Style.STROKE); 
		drawPaint.setStrokeJoin(Paint.Join.ROUND); 
		drawPaint.setStrokeCap(Paint.Cap.ROUND); 

		//in onDraw(Canvas canvas) 
		canvas.drawBitmap(canvasBitmap, 0, 0, null); 
		canvas.drawPath(drawPath, drawPaint); 
		//when your path is finished 
		drawCanvas.drawPath(drawPath, drawPaint);
	//	drawPath = new Path();

	}
	
	@Override 
	 public boolean onTouchEvent(MotionEvent event) { 
	 //fetch the location 

		
		
	 float x = event.getX();
	 float y = event.getY();

	 if(event.getAction() == MotionEvent.ACTION_DOWN){
		 drawPath.moveTo(x,y);
		 drawPath.lineTo(x, y);
	 } else if (event.getAction() == MotionEvent.ACTION_MOVE){
		 drawPath.lineTo(x, y);
	 } else if (event.getAction() == MotionEvent.ACTION_UP){
		 drawPath.lineTo(x, y);
		 //drawCanvas.drawPath(drawPath, drawPaint); 
		 //drawPath.reset();
	 }
	 this.invalidate();
	 return true; 
	 }
	
	public void changeColor(int color){
		c = color;
		if(c != Color.WHITE){
			oudekleur = c;
		}
		drawPath = new Path();
	}
	
	public void draw(){
		drawPath = new Path();
		c = oudekleur;
	}
	
	public void newDrawing(){
		canvasBitmap = Bitmap.createBitmap(480, 480, Bitmap.Config.ARGB_8888);
		drawPath = new Path();
        invalidate();
		
	}
}
