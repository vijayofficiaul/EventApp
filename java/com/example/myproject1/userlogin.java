package com.example.myproject1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject1.databinding.ActivityLoginBinding;
import com.example.myproject1.databinding.ActivityUserloginBinding;

public class userlogin extends AppCompatActivity {

    ActivityUserloginBinding binding;
    DatabaseHelper1 databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserloginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper1(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(email.equals("")||password.equals(""))
                    Toast.makeText(userlogin.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                    if(checkCredentials == true){
                        Toast.makeText(userlogin.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(userlogin.this,UserHome.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(userlogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userlogin.this, Registration.class);
                startActivity(intent);
            }
        });
    }
}