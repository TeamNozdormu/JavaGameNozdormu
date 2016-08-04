package com.company.utilities;

import java.util.Random;

public class RandomGenerator {

    private static Random random;

    private static void init() {
        random = new Random();
    }

    public static double getNextDoubleRandom() {
        if (random == null) {
            init();
        }

        return random.nextDouble();
    }

    public static int getNextIntRandom(int number) {
        if (random == null) {
            init();
        }

        return random.nextInt(number);
    }
}
