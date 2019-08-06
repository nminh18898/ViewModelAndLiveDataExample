package com.example.viewmodelandlivedataexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class ControlFragment extends Fragment implements View.OnClickListener {

    private Medal mMedal;
    Button btnDecrease;
    Button btnIncrease;
    TextView tvGoldMedal, tvSilverMedal, tvBronzeMedal;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_control, null);
        btnIncrease = root.findViewById(R.id.btnIncrease);
        btnDecrease = root.findViewById(R.id.btnDecrease);

        tvGoldMedal = root.findViewById(R.id.tvGoldMedal);
        tvSilverMedal = root.findViewById(R.id.tvSilverMedal);
        tvBronzeMedal = root.findViewById(R.id.tvBronzeMedal);

        mMedal = ViewModelProviders.of(getActivity()).get(Medal.class);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        displayMedal();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnIncrease:
                mMedal.setNumbersOfGold(mMedal.getNumbersOfGold() + 1);
                mMedal.setNumbersOfSilver(mMedal.getNumbersOfSilver() + 1);
                mMedal.setNumbersOfBronze(mMedal.getNumbersOfBronze() + 1);
                displayMedal();
                break;

            case R.id.btnDecrease:
                mMedal.setNumbersOfGold(mMedal.getNumbersOfGold() - 1);
                mMedal.setNumbersOfSilver(mMedal.getNumbersOfSilver() - 1);
                mMedal.setNumbersOfBronze(mMedal.getNumbersOfBronze() - 1);
                displayMedal();
                break;

        }


    }

    void displayMedal()
    {

        tvGoldMedal.setText("Gold: " + mMedal.getNumbersOfGold());
        tvSilverMedal.setText("Silver: " +mMedal.getNumbersOfSilver());
        tvBronzeMedal.setText("Bronze: " + mMedal.getNumbersOfBronze());

    }
}
