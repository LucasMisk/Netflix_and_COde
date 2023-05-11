package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;
import java.util.Random;
import java.math.BigInteger;

public class SingleCoreBenchmark implements iBenchmark{
    // implements a Lucas–Lehmer primality test
    int workload;
    @Override
    public void run() {
        int p = 21701; // Test for Mersenne prime 2^21701 - 1
        boolean isPrime = isMersennePrime(p);
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(Object... params) {
        workload = (int)params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {
        int p = 2281; // Test for Mersenne prime 2^21701 - 1
        boolean isPrime = isMersennePrime(p);
    }

    public static boolean isMersennePrime(int p) {
        BigInteger mersenne = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
        BigInteger s = BigInteger.valueOf(4);
        for (int i = 0; i < p - 2; i++) {
            s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(mersenne);
        }
        return s.equals(BigInteger.ZERO);
    }

}

