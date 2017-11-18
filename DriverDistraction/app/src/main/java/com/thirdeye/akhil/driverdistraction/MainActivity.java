package com.thirdeye.akhil.driverdistraction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.shitij.goyal.slidebutton.SwipeButton;

import java.sql.Time;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
SwipeButton swipeButton;
Typeface typeface;
TextView distance,speed,brake,brake_harsh,corner,corner_harsh,dd,value;


// Using for Demonstration
CountDownTimer timerSet;
double distanceCovered=0.0;
int speedinKms=0;
double var=0.0;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        timerInitiate();
        distance.setText(String.valueOf(distanceCovered)+ " Km");
        speed.setText(String.valueOf(speedinKms)+" Km/Hr");
        timerSet.start();
         swipeButton.addOnSwipeCallback(new SwipeButton.Swipe() {
             @Override
             public void onButtonPress() {

             }

             @Override
             public void onSwipeCancel() {

             }

             @Override
             public void onSwipeConfirm() {
                 timerSet.cancel();
                 Intent thirdPage=new Intent(MainActivity.this, com.thirdeye.akhil.driverdistraction.thirdPage.class);
                thirdPage.putExtra("tdistance",distance.getText().toString());
                thirdPage.putExtra("speed",speed.getText().toString());
                thirdPage.putExtra("ddstatus",dd.getText().toString());
                thirdPage.putExtra("harshcorner",corner_harsh.getText().toString());
                thirdPage.putExtra("harshbrake",brake_harsh.getText().toString());
                startActivity(thirdPage);


             }
         });


    }

    private void timerInitiate() {

        timerSet=new CountDownTimer(180000,1000) {
            @Override
            public void onTick(long l) {

                speed.setText(String.valueOf(speedinKms)+" Km/Hr");
                distanceCovered=var+(speedinKms/360.0);
                 var=speedinKms/360.0;

                distance.setText(String.valueOf(new DecimalFormat("##.#").format(distanceCovered))+" Km");

                if(speedinKms>55 && speedinKms< 75)
                    speedinKms+=2;
                else if(speedinKms>100)
                {
                    distanceCovered=var+(speedinKms/360.0);
                    var=speedinKms/360.0;
                }
                else
                    speedinKms+=3;

                if(speedinKms<75){
                    corner_harsh.setText("Good");
                    corner_harsh.setTextColor(Color.parseColor("#235e2c"));
                }

                else
                {
                    corner_harsh.setText("Harsh");
                    corner_harsh.setTextColor(Color.RED);
                }
              if(speedinKms<99)
              {
                  brake_harsh.setText("Good");
                  brake_harsh.setTextColor(Color.parseColor("#235e2c"));
              }
              else
              {
                  speedinKms=60;
                  speed.setText("60 Km/Hr");
                  brake_harsh.setText("Harsh");
                  brake_harsh.setTextColor(Color.RED);
              }

            }


            @Override
            public void onFinish() {
                Intent thirdPage=new Intent(MainActivity.this, com.thirdeye.akhil.driverdistraction.thirdPage.class);
                thirdPage.putExtra("tdistance",distance.getText().toString());
                thirdPage.putExtra("speed",speed.getText().toString());
                thirdPage.putExtra("ddstatus",dd.getText().toString());
                thirdPage.putExtra("harshcorner",corner_harsh.getText().toString());
                thirdPage.putExtra("harshbrake",brake_harsh.getText().toString());
                startActivity(thirdPage);
            }
        };
    }

    private void initiate() {
        distance=(TextView)findViewById(R.id.distance_covered);
        speed=(TextView)findViewById(R.id.speedText);
        dd=(TextView)findViewById(R.id.ddplaintext);
        brake=(TextView)findViewById(R.id.brakingtxt);
        brake_harsh=(TextView)findViewById(R.id.brake_harsh);
        corner=(TextView)findViewById(R.id.corneringtxt);
        corner_harsh=(TextView)findViewById(R.id.harsh_corner);
        value=(TextView)findViewById(R.id.dd);
        swipeButton=(SwipeButton)findViewById(R.id.swipe);
        typeface=Typeface.createFromAsset(getAssets(),"fonts/font2.ttf");
        distance.setTypeface(typeface);
        speed.setTypeface(typeface);
        dd.setTypeface(typeface);
        brake.setTypeface(typeface);
        brake_harsh.setTypeface(typeface);
        corner_harsh.setTypeface(typeface);
        corner.setTypeface(typeface);
        value.setTypeface(typeface);
        swipeButton.setTypeface(typeface);
        brake_harsh.setTextColor(Color.RED);
        corner_harsh.setTextColor(Color.RED);

    }
}
