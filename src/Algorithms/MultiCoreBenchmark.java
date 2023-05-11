package Algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiCoreBenchmark implements iBenchmark{
    public static void multiply(double[][] result, int numThreads) {
        int numRowsA = 200;
        int numColsA = 200;
        int numRowsResult = result.length;
        int numColsResult = result[0].length;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numRowsResult; i++) {
            for (int j = 0; j < numColsResult; j++) {
                executor.execute(new MultiplyTask(result, i, j));
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    @Override
    public void run(Object... params) {
        int numThreads = (Integer)params[0];
        double [][] result = new double[200][200];
        multiply(result, numThreads);
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

    public static double[][] generateMatrix(int number)
    {
        Random rand = new Random();
        double [][] result = new double[number][number];
        for(int i = 0; i < number; i++)
        {
            for(int j = 0; j < number; j++)
            {
                result[i][j] = rand.nextDouble();
            }
        }
        return result;
    }

    private static class MultiplyTask implements Runnable {

        private double[][] a=generateMatrix(200);

        private double[][] result;
        private int row;
        private int col;

        public MultiplyTask(double[][] result, int row, int col) {
            this.result = result;
            this.row = row;
            this.col = col;
        }

        public void run() {
            int numColsA = a[0].length;
            double sum = 0;

            for (int k = 0; k < numColsA; k++) {
                sum += a[row][k] * a[k][col];
            }

            result[row][col] = sum;
        }
    }
}