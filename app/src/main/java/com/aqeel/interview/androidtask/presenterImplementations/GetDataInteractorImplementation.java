package com.aqeel.interview.androidtask.presenterImplementations;

import android.util.Log;

import com.aqeel.interview.androidtask.api_interfaces.SearchApi;
import com.aqeel.interview.androidtask.data.ApisService;
import com.aqeel.interview.androidtask.datamodels.Drink;
import com.aqeel.interview.androidtask.datamodels.Drinks;
import com.aqeel.interview.androidtask.presenters.MainPresenter;
import com.aqeel.interview.androidtask.utils.SearchType;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataInteractorImplementation implements MainPresenter.GetDataIntractor {
    @Override
    public void getDataArrayList(OnFinishedListener onFinishedListener, String drinkName, SearchType type) {
        switch (type)
        {
            case SEARCH_BY_NAME:{
                getDrinksDataByName(onFinishedListener,drinkName);
                break;
            }
            case SEARCH_BY_ALPHABET: {
                getDrinksDataByAlphabet(onFinishedListener,drinkName);
                break;
            }
        }


    }
    private void getDrinksDataByName(OnFinishedListener onFinishedListener,String drinkName)
    {
        /** Create handle for the RetrofitInstance interface*/
        SearchApi service = ApisService.getClient().create(SearchApi.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<Drinks> call = service.getDrinksByName(drinkName);

        /**Log the URL called*/
        Log.i("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                Drinks drinks = response.body();
                onFinishedListener.onFinished(drinks.getDrinks());

            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }


    private void getDrinksDataByAlphabet(OnFinishedListener onFinishedListener,String drinkName)
    {
        SearchApi service = ApisService.getClient().create(SearchApi.class);
        Call<Drinks> call = service.getDrinkByAlphabet(drinkName);
        Log.i("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Drinks>() {
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                Drinks drinks = response.body();
                onFinishedListener.onFinished(drinks.getDrinks());

            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
