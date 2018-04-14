package com.kodilla.rps;

public class rpsGameSetup {
    private int turns;
    private int difficulty;
    private rpsPlayer playerH;
    private rpsPlayer playerC;

    public rpsGameSetup() {
        this.playerH = new humanPlayer();
        humanPlayer player = (humanPlayer) playerH;
        player.getName();
        this.difficulty=player.getDifficulty();
        this.turns=player.getNumberOfTurns();
        this.playerC=new computerPlayer();
    }

    public int getTurns() {
        return turns;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public rpsPlayer getPlayerH() {
        return playerH;
    }

    public rpsPlayer getPlayerC() {
        return playerC;
    }
}
