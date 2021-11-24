package com.example.blooddonar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button button_login;
    EditText editText_mno, editText_pass;
    String string_mno, string_pass;
    String mob_match = "[6-9]{1}[0-9]{9}";
    TextView textView_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        button_login = (Button) findViewById(R.id.btn_login_login);
        editText_mno = (EditText) findViewById(R.id.et_login_no);
        editText_pass = (EditText) findViewById(R.id.et_login_pass);
        textView_register = (TextView) findViewById(R.id.tv_login_register);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string_mno = editText_mno.getText().toString();
                string_pass = editText_pass.getText().toString();


                if (string_mno.isEmpty()) {
                    editText_mno.setError("Enter Mobileno");
                    editText_mno.requestFocus();
                    Toast.makeText(Login.this, "Enter Mobileno", Toast.LENGTH_SHORT).show();
                }

                else if (!string_mno.matches(mob_match)) {
                    editText_mno.setError("Invalid Number");
                    editText_mno.requestFocus();
                }

                else if (string_pass.isEmpty()) {
                    editText_pass.setError("Enter Password");
                    editText_pass.requestFocus();
                    Toast.makeText(Login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }

                else{

                    Toast.makeText(Login.this, "Your In", Toast.LENGTH_SHORT).show();

                    Intent fourIntent=new Intent(Login.this,Home.class);
                    startActivity(fourIntent);
                }
            }
        });


        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdintent=new Intent(Login.this,Registration.class);
                startActivity(thirdintent);
            }
        });


    }
}
