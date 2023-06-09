package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.CacheScore;
import Score.iScore;
import Timer.*;

public class TestCache {
    public static void main(String[] args)
    {
        final long workload=100000000;
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new CacheScore();

        iBenchmark bench = new CacheBenchmark();
        bench.initialize(workload);
        bench.warmup();
        timer.start();
        bench.run();
        long time = timer.stop();
        int score = scorer.getScore(time);
        log.writeTime("Cache Benchmark finished in", time, Milisecond);
        log.write("Score: " + score);
        flog.write(score);
        flog.close();
        log.close();
        bench.clean();
    }
}