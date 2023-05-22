package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.SingleCoreScore;
import Score.iScore;
import Timer.*;

public class TestSingleCore {
    public static void main(String[] args)
    {
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new SingleCoreScore();

        iBenchmark bench = new SingleCoreBenchmark();
        bench.warmup();
        timer.start();
        bench.run();
        long time = timer.stop();
        int score = scorer.getScore(time);
        log.writeTime("Single Core Benchmark finished in", time, Milisecond);
        log.write("Score: " + score);
        log.close();
        flog.write(score);
        flog.close();
        bench.clean();
    }
}
