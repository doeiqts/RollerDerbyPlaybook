package com.doeiqts.rollerderbyplaybook;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RolleryDerbyPlaybookActivity extends Activity implements OnTouchListener {
	// White team
	ImageView whiteJammer;
	ImageView whitePivot;
	ImageView whiteBlocker1;
	ImageView whiteBlocker2;
	ImageView whiteBlocker3;
	
	// Black team
	ImageView blackJammer;
	ImageView blackPivot;
	ImageView blackBlocker1;
	ImageView blackBlocker2;
	ImageView blackBlocker3;
	
	// Screen info
	Display display;
	int width;
	int height;
	
	// Margin variables
	// White team
	MarginLayoutParams whiteJammerMarginParams;
	RelativeLayout.LayoutParams whiteJammerLayoutParams;
	MarginLayoutParams whitePivotMarginParams;
	RelativeLayout.LayoutParams whitePivotLayoutParams;
	MarginLayoutParams whiteBlocker1MarginParams;
	RelativeLayout.LayoutParams whiteBlocker1LayoutParams;
	MarginLayoutParams whiteBlocker2MarginParams;
	RelativeLayout.LayoutParams whiteBlocker2LayoutParams;
	MarginLayoutParams whiteBlocker3MarginParams;
	RelativeLayout.LayoutParams whiteBlocker3LayoutParams;
	
	// Black team
	MarginLayoutParams blackJammerMarginParams;
	RelativeLayout.LayoutParams blackJammerLayoutParams;
	MarginLayoutParams blackPivotMarginParams;
	RelativeLayout.LayoutParams blackPivotLayoutParams;
	MarginLayoutParams blackBlocker1MarginParams;
	RelativeLayout.LayoutParams blackBlocker1LayoutParams;
	MarginLayoutParams blackBlocker2MarginParams;
	RelativeLayout.LayoutParams blackBlocker2LayoutParams;
	MarginLayoutParams blackBlocker3MarginParams;
	RelativeLayout.LayoutParams blackBlocker3LayoutParams;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rollery_derby_playbook);
        
        // Get the players
        whiteJammer = (ImageView) findViewById(R.id.whitejammer);
        whitePivot = (ImageView) findViewById(R.id.whitepivot);
        whiteBlocker1 = (ImageView) findViewById(R.id.whiteblocker1);
        whiteBlocker2 = (ImageView) findViewById(R.id.whiteblocker2);
        whiteBlocker3 = (ImageView) findViewById(R.id.whiteblocker3);
        blackJammer = (ImageView) findViewById(R.id.blackjammer);
        blackPivot = (ImageView) findViewById(R.id.blackpivot);
        blackBlocker1 = (ImageView) findViewById(R.id.blackblocker1);
        blackBlocker2 = (ImageView) findViewById(R.id.blackblocker2);
        blackBlocker3 = (ImageView) findViewById(R.id.blackblocker3);
        
        // Get screen information
        display = getWindowManager().getDefaultDisplay(); 
        width = display.getWidth();
        height = display.getHeight();
        
        // Set players according to the screen
        // White Jammer
        whiteJammerMarginParams = new MarginLayoutParams(whiteJammer.getLayoutParams());
        whiteJammerMarginParams.setMargins((int) (width * .35), (int) (height * .32), 0, 0);
        whiteJammerLayoutParams = new RelativeLayout.LayoutParams(whiteJammerMarginParams);
        whiteJammer.setLayoutParams(whiteJammerLayoutParams);
        whiteJammer.setOnTouchListener(this);
        
        // White Pivot
        whitePivotMarginParams = new MarginLayoutParams(whitePivot.getLayoutParams());
        whitePivotMarginParams.setMargins((int) (width * .42), (int) (height * .32), 0, 0);
        whitePivotLayoutParams = new RelativeLayout.LayoutParams(whitePivotMarginParams);
        whitePivot.setLayoutParams(whitePivotLayoutParams);
        whitePivot.setOnTouchListener(this);
        
        // White Blocker 1
        whiteBlocker1MarginParams = new MarginLayoutParams(whiteBlocker1.getLayoutParams());
        whiteBlocker1MarginParams.setMargins((int) (width * .49), (int) (height * .32), 0, 0);
        whiteBlocker1LayoutParams = new RelativeLayout.LayoutParams(whiteBlocker1MarginParams);
        whiteBlocker1.setLayoutParams(whiteBlocker1LayoutParams);
        whiteBlocker1.setOnTouchListener(this);
        
        // White Blocker 2
        whiteBlocker2MarginParams = new MarginLayoutParams(whiteBlocker2.getLayoutParams());
        whiteBlocker2MarginParams.setMargins((int) (width * .56), (int) (height * .32), 0, 0);
        whiteBlocker2LayoutParams = new RelativeLayout.LayoutParams(whiteBlocker2MarginParams);
        whiteBlocker2.setLayoutParams(whiteBlocker2LayoutParams);
        whiteBlocker2.setOnTouchListener(this);
        
        // White Blocker 3
        whiteBlocker3MarginParams = new MarginLayoutParams(whiteBlocker3.getLayoutParams());
        whiteBlocker3MarginParams.setMargins((int) (width * .63), (int) (height * .32), 0, 0);
        whiteBlocker3LayoutParams = new RelativeLayout.LayoutParams(whiteBlocker3MarginParams);
        whiteBlocker3.setLayoutParams(whiteBlocker3LayoutParams);
        whiteBlocker3.setOnTouchListener(this);
        
        // Black Jammer
        blackJammerMarginParams = new MarginLayoutParams(blackJammer.getLayoutParams());
        blackJammerMarginParams.setMargins((int) (width * .35), (int) (height * .52), 0, 0);
        blackJammerLayoutParams = new RelativeLayout.LayoutParams(blackJammerMarginParams);
        blackJammer.setLayoutParams(blackJammerLayoutParams);
        blackJammer.setOnTouchListener(this);
        
        // Black Pivot
        blackPivotMarginParams = new MarginLayoutParams(whitePivot.getLayoutParams());
        blackPivotMarginParams.setMargins((int) (width * .42), (int) (height * .52), 0, 0);
        blackPivotLayoutParams = new RelativeLayout.LayoutParams(blackPivotMarginParams);
        blackPivot.setLayoutParams(blackPivotLayoutParams);
        blackPivot.setOnTouchListener(this);
        
        // Black Blocker 1
        blackBlocker1MarginParams = new MarginLayoutParams(blackBlocker1.getLayoutParams());
        blackBlocker1MarginParams.setMargins((int) (width * .49), (int) (height * .52), 0, 0);
        blackBlocker1LayoutParams = new RelativeLayout.LayoutParams(blackBlocker1MarginParams);
        blackBlocker1.setLayoutParams(blackBlocker1LayoutParams);
        blackBlocker1.setOnTouchListener(this);
        
        // Black Blocker 2
        blackBlocker2MarginParams = new MarginLayoutParams(blackBlocker2.getLayoutParams());
        blackBlocker2MarginParams.setMargins((int) (width * .56), (int) (height * .52), 0, 0);
        blackBlocker2LayoutParams = new RelativeLayout.LayoutParams(blackBlocker2MarginParams);
        blackBlocker2.setLayoutParams(blackBlocker2LayoutParams);
        blackBlocker2.setOnTouchListener(this);
        
        // Black Blocker 3
        blackBlocker3MarginParams = new MarginLayoutParams(blackBlocker3.getLayoutParams());
        blackBlocker3MarginParams.setMargins((int) (width * .63), (int) (height * .52), 0, 0);
        blackBlocker3LayoutParams = new RelativeLayout.LayoutParams(blackBlocker3MarginParams);
        blackBlocker3.setLayoutParams(blackBlocker3LayoutParams);
        blackBlocker3.setOnTouchListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_rollery_derby_playbook, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Only have "Save" menu item, so just code for that
    	
    	// Create screenshot
    	View view = (View) findViewById(R.id.track);
    	view.setDrawingCacheEnabled(true);
    	Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
    	view.setDrawingCacheEnabled(false);
    	
    	// Create file and save to SD card
	    File file = new File(Environment.getExternalStorageDirectory().getPath() + "/rollerderbyplays/", "rollerderbyplay" + (new Timestamp((int) (System.currentTimeMillis()))).toString() + ".png");
	    try 
	    {
	    	file.getParentFile().mkdirs();
	        file.createNewFile();
	        FileOutputStream ostream = new FileOutputStream(file);
	        bitmap.compress(CompressFormat.PNG, 100, ostream);
	        ostream.close();
	        
	        // Alert the mediascanner that there's a new file
	        MediaScannerConnection.scanFile(this,
	                new String[] { file.toString() }, null, new MediaScannerConnection.OnScanCompletedListener() {
	            			public void onScanCompleted(String path, Uri uri) {}
	        });
	        
	        // Let the user know it was saved
	        Toast.makeText(this, "Play saved!", Toast.LENGTH_SHORT).show();
	    } 
	    catch (Exception e) 
	    {
	    	// Let the user know there was a problem and the file was not saved
	        Toast.makeText(this, "Error saving play!", Toast.LENGTH_SHORT).show();
	        
	        e.printStackTrace();
	    }
    	
    	return true;
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		MarginLayoutParams MarginParams = new MarginLayoutParams(v.getLayoutParams());
		MarginParams.setMargins((int) event.getRawX(), (int) (event.getRawY() - (height * .18)), 0, 0);
		RelativeLayout.LayoutParams LayoutParams = new RelativeLayout.LayoutParams(MarginParams);
		v.setLayoutParams(LayoutParams);
		
		// TODO Auto-generated method stub
		return true;
	}

    
}
