package Algorithms;

public class IntBenchmark implements iBenchmark{
    //implements a prime number generator
    int [] prime;
    int workload;
    @Override
    public void run() {
        prime = generatePrimes(workload);
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
    }
    public static int[] generatePrimes(int numOfPrimes) {
        int[] primes = new int[numOfPrimes];
        primes[0] = 2; // The first prime number
        int count = 1;
        int candidate = 3; // The candidate number to test for primality
        while (count < numOfPrimes) {
            boolean isPrime = true;
            int sqrt = (int) Math.sqrt(candidate);
            for (int i = 0; primes[i] <= sqrt; i++) {
                if (candidate % primes[i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count] = candidate;
                count++;
            }
            candidate += 2; // Only test odd numbers
        }
        return primes;
    }
}
