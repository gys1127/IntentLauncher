package com.android.intentlauncher;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pressButton(View view) {
        Intent intent;
        Button button = (Button) view;

        if (button.getText().equals(getResources().getString(R.string.send_email_button))) {
            intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            EditText titleEditText = findViewById(R.id.title);
            intent.putExtra(Intent.EXTRA_SUBJECT, titleEditText.getText().toString());
            CheckBox onlySendTitleCheckBox = findViewById(R.id.only_send_title);
            if (!onlySendTitleCheckBox.isChecked()) {
                EditText messageEditText = findViewById(R.id.message);
                intent.putExtra(Intent.EXTRA_TEXT, messageEditText.getText().toString());
            }
        } else if (button.getText().equals(getResources().getString(R.string.launch_activity_button))) {
            intent = new Intent(this, AnotherActivity.class);
            EditText titleEditText = findViewById(R.id.title);
            intent.putExtra(Intent.EXTRA_SUBJECT, titleEditText.getText().toString());
            CheckBox onlySendTitleCheckBox = findViewById(R.id.only_send_title);
            if (!onlySendTitleCheckBox.isChecked()) {
                EditText messageEditText = findViewById(R.id.message);
                intent.putExtra(Intent.EXTRA_TEXT, messageEditText.getText().toString());
            }
        } else {
            intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        }

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
