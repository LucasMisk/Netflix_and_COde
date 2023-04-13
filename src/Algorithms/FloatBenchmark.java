package Algorithms;

public class FloatBenchmark implements iBenchmark{
    int N;
    double[][] A;
    double[][] B;

    double[][] C;
    @Override
    public void run() {

    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(Object... params) {
        N=(Integer)params[0];
        A = createRandomMatrix(N);
        B = createRandomMatrix(N);
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
    private static double[][] createRandomMatrix(int N) {
        double[][] matrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Math.random();
            }
        }
        return matrix;
    }
    private static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int N = A.length;
        double[][] C = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
