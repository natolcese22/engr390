package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    protected Button LogInButton = null;
    protected Button createAccountButton=null;
    Databasehelper databasehelper=new Databasehelper(this);

    protected EditText NotAccount=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();

    }

    protected void setupUI() {
        LogInButton = (Button) findViewById(R.id.LogInButton);
        LogInButton.setOnClickListener(onClickLoginButton);
        createAccountButton=(Button)findViewById(R.id.createAccountButton);
        createAccountButton.setOnClickListener(onClickCreateAccountButton);

        NotAccount=(EditText) findViewById(R.id.NotAccount);
        NotAccount.setEnabled(false);
    }

    private void GoToBeginSession() {

        Intent intent = new Intent(this, BeginSession.class);
        startActivity(intent);

    }

    private void GoToCreateAccount() {

        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);

    }


    private Button.OnClickListener onClickLoginButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view) {
            EditText UsernameText = findViewById(R.id.UsernameText);
            String usernameString = UsernameText.getText().toString();

            EditText PasswordText = findViewById(R.id.PasswordText);
            String passwordString = PasswordText.getText().toString();

            String password = databasehelper.searchPassword(usernameString);

            if (passwordString.equals(password)) {
                GoToBeginSession();

            } else {

                Toast temp = Toast.makeText(HomePage.this, "Username and password don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }

        }


    };

    private Button.OnClickListener onClickCreateAccountButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            GoToCreateAccount ();
        }
    };

    /*public void check_Username_and_Password(){

        EditText UsernameText=findViewById(R.id.UsernameText);
        String usernameString=UsernameText.getText().toString();

        EditText PasswordText=findViewById(R.id.PasswordText);
        String passwordString=PasswordText.getText().toString();

        String password=databasehelper.searchPassword(usernameString);

        if(passwordString.equals(password))
        {
            GoToBeginSession();

        }
        else
        {

            Toast temp=Toast.makeText(HomePage.this, "Username and password don't match!", Toast.LENGTH_SHORT);
            temp.show();
        }

    }
    */

}
