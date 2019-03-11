package com.example.y_barham.breathleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    Databasehelper databasehelper=new Databasehelper(this);
    protected Button createNewAccountButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        setupUI();
    }

    protected void setupUI() {
        createNewAccountButton = (Button) findViewById(R.id.createNewAccountButton);
       // createNewAccountButton.setOnClickListener(onClickCreateNewAccountButton);

    }


    private void GoToHomePage() {

        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

    }


    private Button.OnClickListener onClickCreateNewAccountButton = new Button.OnClickListener()

    {
        @Override
        public void onClick(View view){
            GoToHomePage ();
        }
    };


    public void onCreateAccountUpClick(View v)
    {
        if (v.getId()==R.id.createNewAccountButton)

        {
            EditText newUsrnameEditText=findViewById(R.id.newUsrnameEditText);
            EditText password=findViewById(R.id.newPasswordEditText);
            EditText confirmPassword=findViewById(R.id.confirmPasswordEditText);

            String newUsernameString=newUsrnameEditText.getText().toString();
            String passwordString=password.getText().toString();
            String confirmPasswordString=confirmPassword.getText().toString();



            if(!passwordString.equals(confirmPasswordString))
            {
            //popup message

                Toast pass=Toast.makeText(CreateAccount.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }else{
                //inserting the details in the database
                AccountInformation accountInformation=new AccountInformation();
                accountInformation.setUsername(newUsernameString);
                accountInformation.setPassword(passwordString);
                databasehelper.insertAccount(accountInformation);
                GoToHomePage ();
            }

        }


        }

    }

