package com.aqeel.interview.androidtask.presenters;

import com.aqeel.interview.androidtask.datamodels.Drink;
import com.aqeel.interview.androidtask.utils.SearchType;

import java.util.ArrayList;

public interface MainPresenter {
    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick(String searchData);

        void requestDataFromServer(String query, SearchType type);

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Drink> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetDataIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Drink> noticeArrayList);
            void onFailure(Throwable t);
        }

       public void getDataArrayList(OnFinishedListener onFinishedListener,String drinkName,SearchType type);
    }
}
