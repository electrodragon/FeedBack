package com.drunk_assassins.feedbackformbeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String phoneNumber = "+921234567890";

        final EditText feedback = findViewById(R.id.feedbackBox);
        final ImageView sendBtn = findViewById(R.id.feedbacksendBtn);
        final Button callBtn = findViewById(R.id.liveCallBtn);

        feedback.setText("Test Message By Drunk_Assassins");

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (feedback.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Feedback is Empty !", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("sms:" + phoneNumber));
                    intent.putExtra("sms_body", feedback.getText().toString());
                    startActivity(intent);
                }
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

    }
}
