package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.IntScore;
import Score.iScore;
import Timer.*;

public class TestInt {
    public static void main(String[] args)
    {
        final int workload=1000000;
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new IntScore();

        iBenchmark bench = new IntBenchmark();
        bench.initialize(workload);
        bench.warmup();
        timer.start();
        bench.run();
        long time = timer.stop();
        int score = scorer.getScore(time);
        log.writeTime("Int Benchmark finished in", time, Milisecond);
        log.write("Score: " + score);
        log.close();
        flog.write(score);
        flog.close();
        bench.clean();
    }
}
