package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.model.Coin;

import java.io.Serializable;

public class GameWallet implements Serializable {
    private static int MaxNumCoin=20;
    private static int AvailableCoin=20;



    public int getAvailableCoin() {
        return AvailableCoin;
    }


    public int getMaxNumCoin() {
        return MaxNumCoin;
    }

    /**
     * decrease the max number of coin
     */
    public void reduceCoin(){
        MaxNumCoin=MaxNumCoin--;
        if(AvailableCoin > MaxNumCoin){
            AvailableCoin=MaxNumCoin;
        }
    }

    
    /**
     * increase the number of available coin
     */
    public void increase() {
        if(AvailableCoin + 1 > MaxNumCoin)
        {AvailableCoin =  MaxNumCoin;}
        else { AvailableCoin = AvailableCoin++;}
    }

    /**
     * @param i is the value of new available coins
     */
    public void increase(int i) {
        if(AvailableCoin + i > MaxNumCoin){
            AvailableCoin=MaxNumCoin;
        }
        else{AvailableCoin = AvailableCoin + i;}
    }


    /**
     * @param i is the value of coin used
     */
    public void decrease(int i) {
        if(AvailableCoin - i < 0){
            AvailableCoin = 0;
        }
        else{AvailableCoin = AvailableCoin - i;}
    }


    /**
     * decrease the number of available coin
     */
    private void decrease() {
        if(AvailableCoin - 1 < 0){
            AvailableCoin = 0;
        }
        else{AvailableCoin = AvailableCoin--;}
    }


    /**
     * @return a coin if there is a coin available
     */
    public Coin getCoin() {
        if (AvailableCoin > 0) {
            this.decrease();
            return new Coin();
        }
        else return null;
    }

}


