package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final String DEBUGTAG = "HelloActivity";

	
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
    
    public void onClick(View view){
    	
    	Button button1 = (Button) findViewById(R.id.button1);
    	TextView text1 = (TextView) findViewById(R.id.textView1);
    	TextView edittext1 = (TextView) findViewById(R.id.editText1);
    	
    	if(view.equals(button1)){
    		Log.v(DEBUGTAG, "clicked HELLO");
    		if(edittext1.getText() != null){
    			text1.setText("Your name is: " + edittext1.getText());
    			edittext1.setText("");
    		}
    	}
    	
    }
    
}