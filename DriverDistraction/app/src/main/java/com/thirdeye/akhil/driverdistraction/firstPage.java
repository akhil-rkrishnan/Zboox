package com.thirdeye.akhil.driverdistraction;

import android.content.Intent;
import android.graphics.Color;

import android.graphics.Typeface;
import android.os.CountDownTimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;



import com.github.lzyzsd.circleprogress.DonutProgress;                                  /*Here i am using  Custom progress bar for timeout*/

import com.shitij.goyal.slidebutton.SwipeButton;

public class firstPage extends AppCompatActivity {

CountDownTimer timer;
Button button;
int progress=14;
DonutProgress progressBar;
TextView text1,inside;
Typeface typeface;
SwipeButton swipeButton;
    Intent intent;
int count=7,inc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        progressBar= (DonutProgress) findViewById(R.id.cirProgress);
        swipeButton=(SwipeButton)findViewById(R.id.swipe);
        typeface=Typeface.createFromAsset(getAssets(),"fonts/font1.ttf");  //To set the font
        swipeButton.setTypeface(typeface);

        text1=(TextView)findViewById(R.id.head);
        inside=(TextView)findViewById(R.id.insideText);
        text1.setTypeface(typeface);
        inside.setTypeface(typeface);
         progressBar.setFinishedStrokeColor(Color.parseColor("#31416d"));
         inside.setText(String.valueOf(progress+1));
         progressBar.setRotation(270); //srevbits


timer=new CountDownTimer(15000,1000) {
    @Override
    public void onTick(long l) {

        inside.setText(String.valueOf(progress--));
        progressBar.setProgress(count+=6.6);
       System.out.println(inc++);


    }

    @Override
    public void onFinish() {
         inside.setText(String.valueOf(0));
         progressBar.setProgress(100);
         intent=new Intent(firstPage.this,MainActivity.class);
        startActivity(intent);
    }
};
timer.start();

        swipeButton.addOnSwipeCallback(new SwipeButton.Swipe() {
            @Override
            public void onButtonPress() {

            }

            @Override
            public void onSwipeCancel() {
                System.out.println("Swipe Cancelled");
            }

            @Override
            public void onSwipeConfirm() {

                System.out.println("Swipe Confirmed");
                timer.cancel();
                firstPage.this.finish();
            }
        });




    }
}