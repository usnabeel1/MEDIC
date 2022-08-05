package com.ndkapp.www.mediconsult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_contact_us extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    private static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        t1 = findViewById(R.id.call_cs);
        t2 = findViewById(R.id.mail_cs);
        t3 = findViewById(R.id.map_cs);
        i1 = findViewById(R.id.final_call);
        i2 = findViewById(R.id.final_mail);
        i3 = findViewById(R.id.final_map);

        final String num = "8980688666";
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "6015558@stud.nau.edu.ua"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "6015558@stud.nau.edu.ua"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/place/Mykoly+Holeho+St,+7%D0%90,+Kyiv,+Ukraine,+02000/@50.438005,30.4389803,17z/data=!3m1!4b1!4m5!3m4!1s0x40d4cc1e7aa55ebf:0x3820d83ffb8fc7c8!8m2!3d50.438005!4d30.441169"));
                startActivity(bIntent);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/place/Mykoly+Holeho+St,+7%D0%90,+Kyiv,+Ukraine,+02000/@50.438005,30.4389803,17z/data=!3m1!4b1!4m5!3m4!1s0x40d4cc1e7aa55ebf:0x3820d83ffb8fc7c8!8m2!3d50.438005!4d30.441169"));
                startActivity(bIntent);
            }
        });


    }

    private void makePhoneCall(String num)
    {
        if(ContextCompat.checkSelfPermission(activity_contact_us.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity_contact_us.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL );
        }
        else
        {
            String dial = "tel:" +num;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

}
