package com.kodilla.rps;

public class rpsLauncher {
    public static void launchGame(){
        rpsGameSetup setup = new rpsGameSetup();
        rpsGame newGame = new rpsGame(setup);
        newGame.gameOn();
    }
}
