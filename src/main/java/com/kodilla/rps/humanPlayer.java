package com.kodilla.rps;

import java.util.Scanner;

public class humanPlayer implements rpsPlayer {
    private String name;

    public void getName(){
        System.out.println("What is your name?");
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
        System.out.println("Welcome, " + this.name +"!");
    }
    public String play(){
        boolean check = true;
        System.out.println("What is your next move?");
        System.out.println("(Select: 1: rock, 2: paper, 3: scissors, x: exit, n: new game)");
        Scanner sc = new Scanner(System.in);
        String input = null;
        while(check){
            input = sc.next();
            if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("x") || input.equals("n")){
                check = false;
            } else {
                System.out.println("Invalid symbol, please try again");
            }
        }
        return input;
    }

    public int getDifficulty(){
        System.out.println("Please select difficulty level: 1 - normal, 2 - difficult");
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int input = 1;
        while (check) {
            input = sc.nextInt();
            if(input == 1 || input ==2) {
                check=false;
            } else {
                System.out.println("Invalid input, please try again");
            }

        }
        return input;
    }

    public int getNumberOfTurns(){
        System.out.println("Please select number of turns (1-10)");
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int input = 1;
        while (check) {
            input = sc.nextInt();
            if(input <=10) {
                check=false;
            } else {
                System.out.println("Invalid input, please try again");
            }

        }
        return input;
    }
}
