package com.example.webwerks.simpletimer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
   private Button startbutton;
   private Button pausebutton;
   private Button resetbutton;
   private Chronometer chronomet;
   private long pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbutton = (Button) findViewById(R.id.start);
        pausebutton = (Button) findViewById(R.id.pause);
        resetbutton = (Button) findViewById(R.id.stop);
        chronomet =(Chronometer) findViewById(R.id.timer);
        pausebutton.setEnabled(false);
        resetbutton.setEnabled(false);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pause=SystemClock.elapsedRealtime();
             if(pause != 0){
                 chronomet.setBase(chronomet.getBase()+SystemClock.elapsedRealtime()-pause);
             }else{
                 chronomet.setBase(SystemClock.elapsedRealtime());
             }
             chronomet.start();
             startbutton.setEnabled(false);
             pausebutton.setEnabled(true);
             resetbutton.setEnabled(true);

            }
        });

        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause = SystemClock.elapsedRealtime();
                chronomet.stop();
                pausebutton.setEnabled(false);
                startbutton.setEnabled(true);
            }
        });

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronomet.stop();
                pausebutton.setEnabled(false);
                resetbutton.setEnabled(false);
                startbutton.setEnabled(true);
                chronomet.setBase(SystemClock.elapsedRealtime());
                pause= (long)0;

            }
        });
    }
}
