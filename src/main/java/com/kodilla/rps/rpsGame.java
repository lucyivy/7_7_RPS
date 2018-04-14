package com.kodilla.rps;

import java.util.Scanner;

public class rpsGame {
    private rpsGameSetup gameSetup;
    private boolean end = false;

    public rpsGame(rpsGameSetup gameSetup) {
        this.gameSetup = gameSetup;
    }

    private int turn() {
        String humanMove=gameSetup.getPlayerH().play();
        int humanAction = readPlayerAction(humanMove, "You");
        if(humanAction==10){
            return 5;
        } else if (humanAction==15){
            return 15;
        }
        String computerMove=null;
        if(gameSetup.getDifficulty()!=1) {
            computerMove = gameSetup.getPlayerC().play();
            while(computerMove.equals(humanMove)) {
                if(humanMove.equals("1")) {
                    computerMove = "2";
                } else {
                    computerMove = gameSetup.getPlayerC().play();
                }
            }
        } else {
            computerMove = gameSetup.getPlayerC().play();
        }
        int computerAction = readPlayerAction(computerMove, "Computer");
        return checkWinner(humanAction, computerAction);
    }

    private int readPlayerAction(String move, String player) {
        if (move.equals("x")){
            this.quit();
            return 10;
        } else if(move.equals("n")){
            this.newGame();
            return 15;
        }  else if(move.equals("1")) {
            System.out.println(player + " played rock!");
            return 1;
        }  else if(move.equals("2")){
            System.out.println(player + " played paper!");
            return 2;
        } else if(move.equals("3")){
            System.out.println(player + " played scissors!");
            return 3;
        } else {
            return 10;
        }
    }
    private int checkWinner(int humanAction, int computerAction){
        if(humanAction==computerAction){
            System.out.println("It's a draw!\n");
            return 0;
        } else if(humanAction==(computerAction%3+1)){
            System.out.println("Congratulations! You won this turn!\n");
            return 1;
        } else {
            System.out.println("Sorry, you lose this turn!\n");
            return -1;
        }
    }

    private void newGame() {
        System.out.println("Are you sure you want to quit current game? Press y for yes, press any other key for no");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(input.equals("y")) {
            end=true;
            rpsLauncher.launchGame();
        }
    }

    private void quit() {
        System.out.println("Are you sure you want to quit? Press y for yes, press any other key for no");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(input.equals("y")) {
            end=true;
        }
    }

    public void gameOn() {
        int turnNo = 0;
        int wins = 0;
        int draws = 0;
        boolean newGameRequested = false;
        final int limit = gameSetup.getTurns();

        while(!end && !(turnNo>=limit)){
            System.out.println("Starting turn no. "+ (turnNo+1));
            int turnResult = turn();
            if(turnResult==1){
                wins++;
            } else if(turnResult==0){
                draws++;
            } else if(turnResult==15){
                newGameRequested=true;
                break;
            }
            if(turnResult!=5){
                turnNo++;
            }
        }
        if(!newGameRequested){
            System.out.println("The game is finished.");
            System.out.println("You won "+ wins + " turns. Computer won "+ (turnNo-wins-draws)+" turns.\nOther matches ended with a draw.");
            System.out.println("If you want to play again, press y. Press any other to quit");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if(input.equals("y")){
                rpsLauncher.launchGame();
            }
        }
    }
}
