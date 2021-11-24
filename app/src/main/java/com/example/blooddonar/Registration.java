package com.example.blooddonar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;
    Button button_register;
    Spinner spinner_Bloodgroup,spinner_Type;
    String string_name, string_mno, string_email, string_pass, string_cpass, string_state, string_city, string_bloodgroup,string_type;
    String mob_match = "[6-9]{1}[0-9]{9}";
    TextView textView_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        textView_login = (TextView) findViewById(R.id.tv_reg_already);
        editText1 = (EditText) findViewById(R.id.et_reg_name);
        editText2 = (EditText) findViewById(R.id.et_reg_no);
        editText3 = (EditText) findViewById(R.id.et_reg_id);
        editText4 = (EditText) findViewById(R.id.et_reg_pass);
        editText5 = (EditText) findViewById(R.id.et_reg_confirm);
        editText6 = (EditText) findViewById(R.id.et_reg_state);
        editText7 = (EditText) findViewById(R.id.et_reg_city);
        spinner_Bloodgroup = (Spinner) findViewById(R.id.spr_reg_grp);
        spinner_Type = (Spinner) findViewById(R.id.spr_reg_type);
        button_register = (Button) findViewById(R.id.btn_reg_register);


        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string_name = editText1.getText().toString();
                string_mno = editText2.getText().toString();
                string_email = editText3.getText().toString();
                string_pass = editText4.getText().toString();
                string_cpass = editText5.getText().toString();
                string_state = editText6.getText().toString();
                string_city = editText7.getText().toString();
                string_type = spinner_Type.getSelectedItem().toString();
                string_bloodgroup = spinner_Bloodgroup.getSelectedItem().toString();


                if (string_name.isEmpty()) {
                    editText1.setError("Enter name");
                    editText1.requestFocus();

                    Toast.makeText(Registration.this, "Enter name", Toast.LENGTH_SHORT).show();

                }

                if (string_mno.isEmpty()) {
                    editText2.setError("Enter Mobileno");
                    editText2.requestFocus();

                    Toast.makeText(Registration.this, "Enter Mobileno", Toast.LENGTH_SHORT).show();

                } else if (!string_mno.matches(mob_match))
                {
                    editText2.setError("Invalid Number");
                    editText2.requestFocus();
                }

                if (string_email.isEmpty()) {
                    editText3.setError("Enter email");
                    editText3.requestFocus();

                    Toast.makeText(Registration.this, "Enter email", Toast.LENGTH_SHORT).show();

                }
                if (string_pass.isEmpty()) {
                    editText4.setError("Enter Password");
                    editText4.requestFocus();

                    Toast.makeText(Registration.this, "Enter Password", Toast.LENGTH_SHORT).show();

                }
                if (string_cpass.isEmpty()) {
                    editText5.setError("Enter Cpass");
                    editText5.requestFocus();

                    Toast.makeText(Registration.this, "Enter Cpass", Toast.LENGTH_SHORT).show();

                }
                else if (!string_cpass.matches(string_pass))
                {
                    editText2.setError("Invalid Password");
                    editText2.requestFocus();

                    Toast.makeText(Registration.this, "Enter Correct Password", Toast.LENGTH_SHORT).show();
                }
                if (string_state.isEmpty()) {
                    editText6.setError("Enter State");
                    editText6.requestFocus();

                    Toast.makeText(Registration.this, "Enter State", Toast.LENGTH_SHORT).show();

                }

                if (string_city.isEmpty()) {
                    editText7.setError("Enter City");
                    editText7.requestFocus();

                    Toast.makeText(Registration.this, "Enter City", Toast.LENGTH_SHORT).show();

                }
                else {

                    Insert();
                    Toast.makeText(Registration.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent loginIntent= new Intent(Registration.this,Home.class);
                    startActivity(loginIntent);
                }
            }
        });

        textView_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logintent = new Intent(Registration.this, Login.class);
                startActivity(logintent);
            }
        });

    }

    private void Insert() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.CreateAccount(
                string_name, string_mno, string_email, string_pass, string_cpass, string_state, string_city, string_bloodgroup,string_type
        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if (responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if (isSuccess) {

                    //       showCreateSuccessToast();

                } else {
                    // Show Creation Failed Message
                    //     showCreateFailedToast();
                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                //  Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}

