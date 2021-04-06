package com.aqeel.interview.androidtask.presenterImplementations;

import com.aqeel.interview.androidtask.datamodels.Drink;
import com.aqeel.interview.androidtask.presenters.MainPresenter;
import com.aqeel.interview.androidtask.utils.SearchType;

import java.util.ArrayList;

public class MainPresenterImpl implements MainPresenter.presenter, MainPresenter.GetDataIntractor.OnFinishedListener {

    private MainPresenter.MainView mainView;
    private MainPresenter.GetDataIntractor getDataIntractor;

    public MainPresenterImpl(MainPresenter.MainView mainView, MainPresenter.GetDataIntractor getDataIntractor) {
        this.mainView = mainView;
        this.getDataIntractor = getDataIntractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;

    }

    @Override
    public void onRefreshButtonClick(String query) {
        if(mainView != null){
            mainView.showProgress();
        }
        getDataIntractor.getDataArrayList(this,query,SearchType.SEARCH_BY_NAME);
    }

    @Override
    public void requestDataFromServer(String query, SearchType type) {
        if(mainView != null){
            mainView.showProgress();
        }
        getDataIntractor.getDataArrayList(this,query,type);

    }

    @Override
    public void onFinished(ArrayList<Drink> datalist) {
        if(mainView != null){
            mainView.setDataToRecyclerView(datalist);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
