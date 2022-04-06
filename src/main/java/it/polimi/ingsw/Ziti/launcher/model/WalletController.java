package it.polimi.ingsw.Ziti.launcher.model;

import it.polimi.ingsw.Ziti.launcher.model.Coin;

public class WalletController {
    private static int MaxNumCoin=20;
    private static int AvaiableCoin=20;



    public int getAvaiableCoin() {
        return AvaiableCoin;
    }


    public int getMaxNumCoin() {
        return MaxNumCoin;
    }

    /**
     * decrease the max number of coin
     */
    public void reduceCoin(){MaxNumCoin=MaxNumCoin--;}

    
    /**
     * increase the number of avaiable coin
     */
    public void increase() {
        if(AvaiableCoin+1>MaxNumCoin)
        {AvaiableCoin =  MaxNumCoin;}
        else { AvaiableCoin = AvaiableCoin++;}
    }

    /**
     * @param i is the value of new avaiable coins
     */
    public void increase(int i) {
        if(AvaiableCoin+i>MaxNumCoin){
            AvaiableCoin=MaxNumCoin;
        }
        else{AvaiableCoin = AvaiableCoin + i;}
    }


    /**
     * @param i is the value of coin used
     */
    public void decrease(int i) {
        if(AvaiableCoin-i<0){
            AvaiableCoin=0;
        }
        else{AvaiableCoin = AvaiableCoin - i;}
    }


    /**
     * decrease the number of avaiable coin
     */
    private void decrease() {
        if(AvaiableCoin-1<0){
            AvaiableCoin=0;
        }
        else{AvaiableCoin = AvaiableCoin--;}
    }


    /**
     * @return a coin if there is a coin avaiable
     */
    public Coin getCoin() {
        if (AvaiableCoin > 0) {
            this.decrease();
            return new Coin();
        }
        else return null;
    }

}


