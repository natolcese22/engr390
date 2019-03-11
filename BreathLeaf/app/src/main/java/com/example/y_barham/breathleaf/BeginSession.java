package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginSession extends AppCompatActivity{
    protected Button BeginSessionButton = null;
    protected Button OptionButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_session);
        setupUI();

    }

    protected void setupUI() {
        BeginSessionButton = (Button) findViewById(R.id.BeginSessionButton);
        BeginSessionButton.setOnClickListener(onClickbeginsessionButton);

        OptionButton = (Button) findViewById(R.id.OptionButton);
        OptionButton.setOnClickListener(onClickOption);
    }

    private void Gotomeditate() {


        Intent intent = new Intent(this, MeditationActivity.class);

        startActivity(intent);

    }

    private Button.OnClickListener onClickbeginsessionButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            Gotomeditate ();
        }
    };

    private void Gotooptions() {


        Intent intent = new Intent(this, OptionsActivity.class);

        startActivity(intent);

    }

    private Button.OnClickListener onClickOption = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            Gotooptions ();
        }
    };
}
