package com.example.drawfree;

import com.example.drawfree.R.color;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Boolean brown = false;
	private Boolean red = false;
	private Boolean black = false;
	private Boolean yellow = false;
	private Boolean green = false;
	private Boolean blue = false;
	ImageButton vorige = null;


	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClickBrown(View view){
    	String normaal = "brown";
    	String checked = "brownchecked";
    	int resIDnormaal = getResources().getIdentifier(normaal , "drawable", getPackageName());
    	int resIDChecked = getResources().getIdentifier(checked , "drawable", getPackageName());
    	uncheckVorige();
    	if(brown){
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDnormaal));
    		brown = false;
    	} else {
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDChecked));   
    		brown = true;
    		DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    		dp.changeColor(Color.rgb(139, 69, 19));
    		vorige = (ImageButton)view;
    	}	    	
    }
    
    public void onClickRed(View view){
    	String normaal = "red";
    	String checked = "redchecked";
    	int resIDnormaal = getResources().getIdentifier(normaal , "drawable", getPackageName());
    	int resIDChecked = getResources().getIdentifier(checked , "drawable", getPackageName());
    	uncheckVorige();
    	if(red){
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDnormaal));
    		red = false;
    	} else {
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDChecked));   
    		red = true;
    		DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    		dp.changeColor(Color.RED);
    		vorige = (ImageButton)view;
    		
    	}	    	
    }
    
    public void onClickBlack(View view){
    	String normaal = "black";
    	String checked = "blackchecked";
    	int resIDnormaal = getResources().getIdentifier(normaal , "drawable", getPackageName());
    	int resIDChecked = getResources().getIdentifier(checked , "drawable", getPackageName());
    	uncheckVorige();
    	if(black){
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDnormaal));
    		black = false;
    	} else {
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDChecked));   
    		black = true;
    		DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    		dp.changeColor(Color.BLACK);
    		vorige = (ImageButton)view;
    	}	    	
    }
    
    public void onClickGreen(View view){
    	String normaal = "green";
    	String checked = "greenchecked";
    	int resIDnormaal = getResources().getIdentifier(normaal , "drawable", getPackageName());
    	int resIDChecked = getResources().getIdentifier(checked , "drawable", getPackageName());
    	uncheckVorige();
    	if(green){
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDnormaal));
    		green = false;
    	} else {
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDChecked));   
    		green = true;
    		DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    		dp.changeColor(Color.GREEN);
    		vorige = (ImageButton)view;
    	}	    	
    }
    
    public void onClickBlue(View view){
    	String normaal = "blue";
    	String checked = "bluechecked";
    	int resIDnormaal = getResources().getIdentifier(normaal , "drawable", getPackageName());
    	int resIDChecked = getResources().getIdentifier(checked , "drawable", getPackageName());
    	uncheckVorige();
    	if(blue){
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDnormaal));
    		blue = false;
    	} else {
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDChecked));   
    		blue = true;
    		DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    		dp.changeColor(Color.BLUE);
    		vorige = (ImageButton)view;
    	}	    	
    }
    
    public void onClickYellow(View view){
    	String normaal = "yellow";
    	String checked = "yellowchecked";
    	int resIDnormaal = getResources().getIdentifier(normaal , "drawable", getPackageName());
    	int resIDChecked = getResources().getIdentifier(checked , "drawable", getPackageName());
    	uncheckVorige();
    	if(yellow){
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDnormaal));
    		yellow = false;
    	} else {
    		((ImageButton)view).setImageDrawable(getResources().getDrawable(resIDChecked));   
    		yellow = true;
    		DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    		dp.changeColor(Color.YELLOW);
    		vorige = (ImageButton)view;
    	}
    	
    }


    public void uncheckVorige(){
    	if(vorige != null){
			if(vorige.getId() == R.id.imageButton5){
				vorige.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("brown" , "drawable", getPackageName())));
			}
			else if(vorige.getId() == R.id.imageButton6){
				vorige.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("red" , "drawable", getPackageName())));
			}
			else if(vorige.getId() == R.id.imageButton7){
				vorige.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("yellow" , "drawable", getPackageName())));
			}
			else if(vorige.getId() == R.id.imageButton8){
				vorige.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("green" , "drawable", getPackageName())));
			} else if(vorige.getId() == R.id.imageButton9){
				vorige.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("blue" , "drawable", getPackageName())));
			} else if(vorige.getId() == R.id.imageButton10){
				vorige.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("black" , "drawable", getPackageName())));
			}
			vorige = null;
		}	
    }
    
    public void onClickErase(View view){
    	DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);
    	dp.changeColor(Color.WHITE);
    }
    
    public void onClickDraw(View view){
    	DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);	
    	dp.draw();
    }
    
    public void newDrawing(View view){
    	DrawingPanel dp = (DrawingPanel)findViewById(R.id.drawing);	
    	dp.newDrawing();
    }
    
}
