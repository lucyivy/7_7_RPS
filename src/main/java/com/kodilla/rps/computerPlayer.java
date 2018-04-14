package com.kodilla.rps;

import java.util.Random;

public class computerPlayer implements rpsPlayer {
    private String name = "Computer";

    public String play() {
        Random random = new Random();
        return String.valueOf(random.nextInt(3)+1);
    }
}
