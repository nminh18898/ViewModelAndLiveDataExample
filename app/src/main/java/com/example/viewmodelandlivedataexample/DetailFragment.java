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
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class DetailFragment extends Fragment {

    TextView tvDetails;
    Medal mMedal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, null);
        tvDetails = root.findViewById(R.id.tvDetails);
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

    private void displayMedal() {
        StringBuilder textToDisplay = new StringBuilder();

        textToDisplay.append("Gold medal: ");
        textToDisplay.append(mMedal.getNumbersOfGold());
        textToDisplay.append(System.getProperty("line.separator"));

        textToDisplay.append("Silver medal: ");
        textToDisplay.append(mMedal.getNumbersOfSilver());
        textToDisplay.append(System.getProperty("line.separator"));

        textToDisplay.append("Bronze medal: ");
        textToDisplay.append(mMedal.getNumbersOfBronze());
        textToDisplay.append(System.getProperty("line.separator"));

        tvDetails.setText(textToDisplay.toString());

    }
}
