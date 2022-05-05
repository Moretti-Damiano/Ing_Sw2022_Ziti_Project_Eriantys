package it.polimi.ingsw.Ziti.launcher;


import it.polimi.ingsw.Ziti.launcher.view.cli;

import java.util.Scanner;

public class InputReadThread implements Runnable{
    private boolean freeInput;
    private String input;
    private Scanner scanner;
    private it.polimi.ingsw.Ziti.launcher.view.cli cli;

    public InputReadThread(cli cli){
        this.cli = cli;
        freeInput = true;
        scanner = new Scanner (System.in);
    }

    @Override
    public void run() {
        while (true){
            if(freeInput){
                input = scanner.nextLine();
                cli.command(input);
            }
        }
    }

    public boolean isFreeInput() {
        return freeInput;
    }

    public void setFreeInput(boolean freeInput) {
        this.freeInput = freeInput;
    }
}
