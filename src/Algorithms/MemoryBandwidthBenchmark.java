package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MemoryBandwidthBenchmark implements iBenchmark{

    private static final int ARRAY_SIZE = 100000000;
    // Allocate two arrays
    int[] array1 = new int[ARRAY_SIZE];
    int[] array2 = new int[ARRAY_SIZE];


    @Override
    public void run() {
        // Memory bandwidth benchmark
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array1[i] += array2[i];
        }
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(Object... params) {
        // Initialize the arrays
        for(int i = 0; i < ARRAY_SIZE; i++) {
            array1[i] = 1;
            array2[i] = 2;
        }
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
