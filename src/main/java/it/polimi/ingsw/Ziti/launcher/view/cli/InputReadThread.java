package it.polimi.ingsw.Ziti.launcher.view.cli;

import java.util.Scanner;

public class InputReadThread implements Runnable{
    private boolean freeInput;
    private final Scanner scanner;
    private final cli cli;
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
            String input = scanner.nextLine();
            if(freeInput){
                cli.command(input);
            }
        }
    }

    public void setFreeInput(boolean freeInput) {
        this.freeInput = freeInput;
    }

    public void close() {
        freeInput = false;
        isOn = false;
    }
}
