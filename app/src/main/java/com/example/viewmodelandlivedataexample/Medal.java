package com.example.viewmodelandlivedataexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Medal extends ViewModel {

    /*public MutableLiveData<Integer> numbersOfGold ;
    public MutableLiveData<Integer> numbersOfSilver;
    public MutableLiveData<Integer> numbersOfBronze;*/



    private MutableLiveData<Integer> numbersOfGold;
    private MutableLiveData<Integer> numbersOfSilver;
    private MutableLiveData<Integer> numbersOfBronze;

    public Medal() {
        /*if(numbersOfGold == null || numbersOfSilver ==  null || numbersOfBronze == null)
        {
            numbersOfGold = new MutableLiveData<>();
            numbersOfSilver = new MutableLiveData<>();
            numbersOfBronze = new MutableLiveData<>();

            numbersOfGold.setValue(0);
            numbersOfSilver.setValue(0);
            numbersOfBronze.setValue(0);
        }*/

        numbersOfGold = new MutableLiveData<>();
        numbersOfSilver = new MutableLiveData<>();
        numbersOfBronze = new MutableLiveData<>();

        numbersOfGold.setValue(0);
        numbersOfSilver.setValue(0);
        numbersOfBronze.setValue(0);
    }

    public int getNumbersOfGold() {
        if(this.numbersOfGold != null) {
            return this.numbersOfGold.getValue();
        }
        else
        {
            return -1;
        }
    }


    public MutableLiveData<Integer> getNumbersOfGoldLiveData() {
        return this.numbersOfGold;
    }



    public void setNumbersOfGold(int numbersOfGold) {
        if(numbersOfGold < 0) {
            numbersOfGold = 0;
        }
        this.numbersOfGold.setValue(numbersOfGold);
    }

    public int getNumbersOfSilver() {

        if(this.numbersOfSilver != null) {
            return this.numbersOfSilver.getValue();
        }
        else
        {
            return -1;
        }
    }

    public MutableLiveData<Integer> getNumbersOfSilverLiveData() {
        return this.numbersOfSilver;
    }


    public void setNumbersOfSilver(int numbersOfSilver) {
        if(numbersOfSilver < 0) {
            numbersOfSilver =0;
        }
        this.numbersOfSilver.setValue(numbersOfSilver);
    }

    public int getNumbersOfBronze() {
        if(this.numbersOfBronze != null) {
            return this.numbersOfBronze.getValue();
        }
        else
        {
            return -1;
        }
    }

    public MutableLiveData<Integer> getNumbersOfBronzeLiveData() {
        return this.numbersOfBronze;
    }

    public void setNumbersOfBronze(int numbersOfBronze) {
        if(numbersOfBronze < 0) {
            numbersOfBronze =0;
        }
        this.numbersOfBronze.setValue(numbersOfBronze);
    }



}