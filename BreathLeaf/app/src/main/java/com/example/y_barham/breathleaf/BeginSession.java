package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BeginSession extends AppCompatActivity{
    protected Button BeginSessionButton = null;
    protected Button OptionButton = null;
    TextView durationText;
    String duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_session);
        setupUI();{

        };
    }

    protected void setupUI() {
        BeginSessionButton = (Button) findViewById(R.id.BeginSessionButton);
        BeginSessionButton.setOnClickListener(onClickbeginsessionButton);
        durationText = (TextView) findViewById(R.id.DurationTextView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings:
                settingsDialogFragment dialog = new settingsDialogFragment();
                dialog.show(getFragmentManager(), "settingsFragment");
            case R.id.calibrate:
                Toast.makeText(this, "Calibration not yet implemented", Toast.LENGTH_SHORT).show();
            case R.id.help:
                Toast.makeText(this, "Help not yet implemented", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void Gotomeditate() {

        duration = durationText.getText().toString();

        Intent intent = new Intent(this, MeditationActivity.class);
        intent.putExtra("duration", duration);

        startActivity(intent);

    }


    private Button.OnClickListener onClickbeginsessionButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            Gotomeditate ();
        }
    };


}
