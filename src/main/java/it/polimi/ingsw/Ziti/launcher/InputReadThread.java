package it.polimi.ingsw.Ziti.launcher;


import it.polimi.ingsw.Ziti.launcher.view.cli.cli;

import java.util.Scanner;

public class InputReadThread implements Runnable{
    private boolean freeInput;
    private String input;
    private Scanner scanner;
    private cli cli;
    private boolean isOn;

    public InputReadThread(cli cli){
        this.cli = cli;
        freeInput = true;
        scanner = new Scanner (System.in);
        isOn = true;
    }

    @Override
    public void run() {
        while (isOn){
            input = scanner.nextLine();
            if(freeInput){
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

    public void close() {
        freeInput = false;
        isOn = false;
    }
}
