package com.company.helperClasses;

import java.util.Random;

public class RandomGenerator {
    private static Random random;

    private static void init(){
        random = new Random();
    }

    public static double getNextRandom()
    {
        if (random == null){
            init();
        }

        return random.nextDouble();
    }
}
