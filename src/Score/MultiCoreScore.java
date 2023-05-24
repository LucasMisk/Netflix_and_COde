package Score;

public class MultiCoreScore implements iScore{

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getScore(Object... params) {
        long time = (long)params[0];
        double time1 = time/1000000000.0;
        return (int)(450000/time1);
    }
}
