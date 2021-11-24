package com.example.blooddonar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api
{
   String BASE_URL = "https://christological-art.000webhostapp.com/api/";

   @POST("https://overland-drills.000webhostapp.com/BLOODDONARAPI/insert.php")
    Call<IsExist> CreateAccount(
            @Query("f1") String string_name,
            @Query("f2") String string_mno,
            @Query("f3") String string_email,
            @Query("f4") String string_pass,
            @Query("f5") String string_cpass,
            @Query("f6") String string_state,
            @Query("f7") String string_city,
            @Query("f8") String string_bloodgroup,
            @Query("f9") String string_type

    );

    @GET("https://overland-drills.000webhostapp.com/BLOODDONARAPI/display.php")
    Call<List<blooddonar>> getPersonDetails(@Query("f9") String string_type);

}
