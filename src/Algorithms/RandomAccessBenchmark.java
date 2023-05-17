package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RandomAccessBenchmark implements iBenchmark{

    private static final int ARRAY_SIZE = 1000000; // Adjust the array size according to your needs
    private static final int ITERATIONS = 1000000000; // Adjust the number of iterations according to your needs

    Random random = new Random();
    int[] array = new int[ARRAY_SIZE];

    @Override
    public void run() {
        for (int i = 0; i < ITERATIONS; i++) {
            int index = random.nextInt(ARRAY_SIZE);
            int value = array[index];
            array[index] = value;
        }
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {
    }

}
