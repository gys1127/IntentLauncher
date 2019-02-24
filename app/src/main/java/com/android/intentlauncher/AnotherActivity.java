package com.android.intentlauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView textView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        intent = getIntent();
        setTitle(intent.getStringExtra(Intent.EXTRA_SUBJECT));
        textView = findViewById(R.id.second_activity_text_view);
        textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
    }
}
