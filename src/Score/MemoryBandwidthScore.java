package Score;

import static java.lang.Math.cbrt;
import static java.lang.Math.sqrt;

public class MemoryBandwidthScore implements iScore{

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getScore(Object... params) {
        double bandwidth = (double)params[0];
        return (int)(cbrt(bandwidth*1000000000)*20);
    }
}
