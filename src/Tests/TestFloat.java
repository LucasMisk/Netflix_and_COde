package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.FloatScore;
import Score.iScore;
import Timer.*;

public class TestFloat {
    public static void main(String[] args)
    {
        final int workload=1000;
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new FloatScore();

        iBenchmark bench = new FloatBenchmark();
        bench.initialize(workload);
        bench.warmup();
        timer.start();
        bench.run();
        long time = timer.stop();
        int score = scorer.getScore(time);
        log.writeTime("Finished in", time, Milisecond);
        log.write("Score: " + score);
        log.close();
        flog.write(score);
        flog.close();
        bench.clean();
    }
}
