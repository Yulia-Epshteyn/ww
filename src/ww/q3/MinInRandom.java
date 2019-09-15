package ww.q3;

import java.util.Arrays;

// Generate 500 random numbers and create a method
// to print the nth smallest number in a programming language of your choice.
public class MinInRandom {
    private static final int SIZE = 500;
    private final double[] numbers = new double[SIZE];

    public MinInRandom() {
        generateRandomNums();
        Arrays.sort(numbers);
    }

    private void generateRandomNums() {
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }
    }

    public double printNthSmallestNum(int n) {
        if (n <= 0 || n > SIZE) {
            throw new IllegalArgumentException();
        }
        return numbers[n - 1];
    }
}
