package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    protected Button StartSessionButton  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        setupUI();

    }

    protected void setupUI() {
        StartSessionButton = (Button) findViewById(R.id.StartSessionButton);
        StartSessionButton.setOnClickListener(onClickstartsessionButton);
    }
    private void Gotomeditation() {


        Intent intent = new Intent(this, MeditationActivity.class);

        startActivity(intent);

    }



    private Button.OnClickListener onClickstartsessionButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            Gotomeditation ();
        }
    };
}
