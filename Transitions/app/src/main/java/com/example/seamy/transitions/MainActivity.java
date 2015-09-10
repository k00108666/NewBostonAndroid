package com.example.seamy.transitions;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;


public class MainActivity extends Activity {


    ViewGroup seamysLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seamysLayout = (ViewGroup) findViewById(R.id.seamysLayout);
        seamysLayout.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        moveButton();

                        return true;
                    }


                }

        );

    }


    public void moveButton () {

        View seamysButton = (Button) findViewById(R.id.seamysButton);
        TransitionManager.beginDelayedTransition(seamysLayout);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        seamysButton.setLayoutParams(positionRules);

        //change the size


        ViewGroup.LayoutParams sizeRules = seamysButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;

        seamysButton.setLayoutParams(sizeRules);

        Log.i("seamysTag", "Moved Button");


            //////////// change the position and size of the button
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
