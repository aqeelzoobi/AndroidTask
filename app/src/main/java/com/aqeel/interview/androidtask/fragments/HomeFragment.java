package com.aqeel.interview.androidtask.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aqeel.interview.androidtask.R;
import com.aqeel.interview.androidtask.adapters.SearchedDrinksAdapter;
import com.aqeel.interview.androidtask.datamodels.Drink;
import com.aqeel.interview.androidtask.listeners.RecyclerItemClickListener;
import com.aqeel.interview.androidtask.presenterImplementations.GetDataInteractorImplementation;
import com.aqeel.interview.androidtask.presenterImplementations.MainPresenterImpl;
import com.aqeel.interview.androidtask.presenters.MainPresenter;
import com.aqeel.interview.androidtask.utils.SearchType;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements MainPresenter.MainView, RecyclerItemClickListener {


    private MainPresenterImpl datalistPresenter;
    private RecyclerView recyclerView;
    private SearchedDrinksAdapter dataAdapter;
    private RadioButton radBtnsearchByName,radBtnseachByAlphabet;
    EditText editTextSearch;
    LinearLayout lay_loadingData;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        dataAdapter = new SearchedDrinksAdapter(new ArrayList<>() , this);
        recyclerView.setAdapter(dataAdapter);
        datalistPresenter=new MainPresenterImpl(this,new GetDataInteractorImplementation());
        datalistPresenter.requestDataFromServer("margarita", SearchType.SEARCH_BY_NAME);
        setOnClickedListeners();
    }
    private void initViews(View view)
    {
        radBtnsearchByName=view.findViewById(R.id.radtiobtn_byname);
        radBtnseachByAlphabet=view.findViewById(R.id.radtiobtn_byalphabet);
        recyclerView=view.findViewById(R.id.rv_searched_drinks);
        editTextSearch = view.findViewById(R.id.edtx_search);
        lay_loadingData=view.findViewById(R.id.lay_loadingData);
        TextView viewTitle =view.findViewById(R.id.txt_title);
        viewTitle.setText("Drinks Recipes");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

    }
    private void setOnClickedListeners()
    {
        radBtnsearchByName.setOnClickListener(v -> {
            updateRadioBtnState(true);
        });
        radBtnseachByAlphabet.setOnClickListener(v -> {
            updateRadioBtnState(false);
        });
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void showProgress() {
        lay_loadingData.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        lay_loadingData.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<Drink> drinkArrayList) {
        updateDataIntoAdapter(drinkArrayList);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(),"Failed to LoadData",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(Drink drink, int position) {

    }

    private void performSearch()
    {
        String query = editTextSearch.getText().toString();
        if(!query.isEmpty())
        {
            if(radBtnsearchByName.isChecked())
            {
                   datalistPresenter.requestDataFromServer(query,SearchType.SEARCH_BY_NAME);
            }else
            {
                datalistPresenter.requestDataFromServer(String.valueOf(query.charAt(0)),SearchType.SEARCH_BY_ALPHABET);
            }
        }

    }
    private void updateRadioBtnState(boolean isByName)
    {
        if(isByName)
        {
            radBtnsearchByName.setChecked(true);
            radBtnseachByAlphabet.setChecked(false);
        }else
        {
            radBtnsearchByName.setChecked(false);
            radBtnseachByAlphabet.setChecked(true);
        }
    }
    private void updateDataIntoAdapter(ArrayList<Drink> drinkArrayList)
    {
       dataAdapter.updateData(drinkArrayList);
    }
}