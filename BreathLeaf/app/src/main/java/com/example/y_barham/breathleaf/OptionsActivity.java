package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsActivity extends AppCompatActivity {
    protected Button SettingsButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        setupUI();

    }

    protected void setupUI() {
        SettingsButton = (Button) findViewById(R.id.SettingsButton);
        SettingsButton.setOnClickListener(onClicksettingsButton);
    }

    private void Gotosettings() {


        Intent intent = new Intent(this, SettingsActivity.class);

        startActivity(intent);

    }



    private Button.OnClickListener onClicksettingsButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            Gotosettings ();
        }
    };
}
