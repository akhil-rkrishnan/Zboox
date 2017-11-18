package com.thirdeye.akhil.driverdistraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class thirdPage extends AppCompatActivity {
RelativeLayout layout;
TextView getWeekday,date,time1,trip,distance,time2;
TextView cumulative_score,digit1,current_score,digit2,avg_score,digit3;
TextView km,ddstatus,corner,warning,total;
TextView tripset;
Typeface typeface;


    Calendar c = Calendar.getInstance();
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    String weekday = new DateFormatSymbols().getShortWeekdays()[dayOfWeek];
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date1 = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        initiate();
        digit1.setText("73");
        digit2.setText("68");
        digit3.setText("59");
        km.setText(getIntent().getExtras().getString("tdistance"));
        ddstatus.setText(getIntent().getExtras().getString("ddstatus")+"  7");
        corner.setText("H : 1");
        warning.setText("H : 1");
        total.setText("68");
        getWeekday.setText(weekday);
        date.setText(dateFormat.format(date1));
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        time1.setText(dateFormat.format(date1));
        time2.setText(dateFormat.format(date1));
        trip.setText("Trip-1");
        distance.setText(getIntent().getExtras().getString("tdistance"));


    }

    private void initiate() {
        trip=(TextView)findViewById(R.id.trip);
        distance=(TextView)findViewById(R.id.distance);
        getWeekday=(TextView)findViewById(R.id.weekday);
        date=(TextView)findViewById(R.id.date);
        time1=(TextView)findViewById(R.id.timeSet);
        time2=(TextView)findViewById(R.id.timeTravelled);
        cumulative_score=(TextView)findViewById(R.id.cumuScore);
        digit1=(TextView)findViewById(R.id.digit1);
        current_score=(TextView)findViewById(R.id.cuScore);
        digit2=(TextView)findViewById(R.id.digit2);
        avg_score=(TextView)findViewById(R.id.avgScore);
        digit3=(TextView)findViewById(R.id.digit3);
        km=(TextView)findViewById(R.id.displayKms);
        ddstatus=(TextView)findViewById(R.id.ddstatus);
        corner=(TextView)findViewById(R.id.corner);
        warning=(TextView)findViewById(R.id.warning);
        total=(TextView)findViewById(R.id.total);
        tripset=(TextView)findViewById(R.id.tripset);


        typeface=Typeface.createFromAsset(getAssets(),"fonts/font2.ttf");

        //Setting Font Style
trip.setTypeface(typeface);
distance.setTypeface(typeface);
        getWeekday.setTypeface(typeface);
        date.setTypeface(typeface);
        time1.setTypeface(typeface);
        time2.setTypeface(typeface);
        cumulative_score.setTypeface(typeface);
        digit1.setTypeface(typeface);
        current_score.setTypeface(typeface);
        digit2.setTypeface(typeface);
        avg_score.setTypeface(typeface);
        digit3.setTypeface(typeface);
        km.setTypeface(typeface);
        ddstatus.setTypeface(typeface);
        corner.setTypeface(typeface);
        warning.setTypeface(typeface);
        total.setTypeface(typeface);
        tripset.setTypeface(typeface);
    }

}
