package com.example.viewmodelandlivedataexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class SummaryFragment extends Fragment {
    Medal mMedal;
    TextView tvSummary;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_summary,null);
        tvSummary = root.findViewById(R.id.tvNumbersOfMedal);
        mMedal = ViewModelProviders.of(getActivity()).get(Medal.class);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayMedal();
        setObservers();
    }

    private void setObservers()
    {
        mMedal.getNumbersOfGoldLiveData().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayMedal();
            }
        });

        mMedal.getNumbersOfBronzeLiveData().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayMedal();
            }
        });

        mMedal.getNumbersOfSilverLiveData().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayMedal();
            }
        });

    }

    void displayMedal()
    {
        int numbersOfMedal = mMedal.getNumbersOfBronze() + mMedal.getNumbersOfGold()
                + mMedal.getNumbersOfSilver();
        tvSummary.setText("Numbers of medal: " + numbersOfMedal);

    }
}
