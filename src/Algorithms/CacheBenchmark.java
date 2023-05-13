package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;
import java.util.Random;

public class CacheBenchmark implements iBenchmark{
    //implements a cache trashing algorithm
    long cacheSize = 32 * 1024 * 1024;
    int arraySize = (int) (cacheSize);
    int[] array = new int[arraySize];
    Random random = new Random();

    long workload;
    @Override
    public void run() {
        randomAccess(workload);
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(Object... params) {
        workload = (long)params[0];
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
    private void randomAccess(long work)
    {
        for (int i = 0; i < work; i++) {
            int index = (i * 16) % array.length;
            array[index] += i;
        }
    }
}
