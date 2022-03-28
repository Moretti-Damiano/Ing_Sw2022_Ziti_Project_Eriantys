package it.polimi.ingsw.Ziti.launcher;

public class WalletController {
    private  static int MaxNumCoin;
    private static int AvaibleCoin;


    private WalletController(){}


    public int GetAvaibleCoin(){
            return AvaibleCoin;
        }


        public int GetMaxNumCoin(){
            return MaxNumCoin;
        }


        /**
         * increase the number of avaible coin
         */
        public void increase(){
            AvaibleCoin=AvaibleCoin++;
        }


        /**
         * decrease the number of avaible coin
         */
        public void decrease(){
            AvaibleCoin=AvaibleCoin--;
        }


        /**
         * @return a coin
         */
        public Coin getCoin(){
            return new Coin();
        }

    }


