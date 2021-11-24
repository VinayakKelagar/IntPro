package com.example.blooddonar;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Viewdonar extends AppCompatActivity
{

    TextView textview1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
    SharedPrefHandler shp;
    String string_type;
    List<blooddonar> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdonar);


        shp=new SharedPrefHandler(this);
        string_type=shp.getSharedPreferences("type");

        Toast.makeText(Viewdonar.this, "Get Value"+string_type, Toast.LENGTH_SHORT).show();

        textview1=(TextView) findViewById(R.id.tv_viewpage_one);
        textView2=(TextView) findViewById(R.id.tv_viewpage_two);
        textView3=(TextView) findViewById(R.id.tv_viewpage_three);
        textView4=(TextView) findViewById(R.id.tv_viewpage_four);
        textView5=(TextView) findViewById(R.id.tv_viewpage_five);
        textView6=(TextView) findViewById(R.id.tv_viewpage_six);
        textView7=(TextView) findViewById(R.id.tv_viewpage_seven);
        textView8=(TextView) findViewById(R.id.tv_viewpage_eight);
        textView9=(TextView) findViewById(R.id.tv_viewpage_nine);


        getPersonDetails(string_type);


    }
    private void getPersonDetails(final String string_type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<blooddonar>> call = api.getPersonDetails(string_type);

        call.enqueue(new Callback<List<blooddonar>>() {
            @Override
            public void onResponse(Call<List<blooddonar>> call, Response<List<blooddonar>> response) {
                productList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    textview1.setText("name : "+productList.get(0).getname());
                    textView2.setText("mno :"+productList.get(0).getmno());
                    textView3.setText("email :"+productList.get(0).getemail());
                    textView4.setText("pass :"+productList.get(0).getpass());
                    textView5.setText("cpass :"+productList.get(0).getcpass());
                    textView6.setText("state :"+productList.get(0).getstate());
                    textView7.setText("city :"+productList.get(0).getcity());
                    textView8.setText("bloodgroup :"+productList.get(0).getbloodgroup());
                    textView9.setText("type :"+productList.get(0).gettype());


                } else {


                }
            }

            @Override
            public void onFailure(Call<List<blooddonar>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
