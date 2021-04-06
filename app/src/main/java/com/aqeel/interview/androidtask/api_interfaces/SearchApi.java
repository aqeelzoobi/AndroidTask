package com.aqeel.interview.androidtask.api_interfaces;

import android.graphics.Movie;

import com.aqeel.interview.androidtask.datamodels.Drink;
import com.aqeel.interview.androidtask.datamodels.Drinks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchApi {

    @GET("search.php")
    Call<Drinks> getDrinksByName(@Query("s") String drickName);

    @GET("search.php")
    Call<Drinks> getDrinkByAlphabet(@Query("f") String drinkcharacter);
}
