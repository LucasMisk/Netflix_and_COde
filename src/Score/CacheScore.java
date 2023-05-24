package Score;

import static java.lang.Math.cbrt;

public class CacheScore implements iScore{
    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getScore(Object... params) {
        long time = (long)params[0];
        double time1 = time/1000000000.0;
        return (int)(cbrt(40000/time1)*1000);
    }
}
