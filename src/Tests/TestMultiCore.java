package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.MultiCoreScore;
import Timer.*;
import Score.*;

public class TestMultiCore {
    public static void main(String[] args)
    {
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new MultiCoreScore();

        iBenchmark bench = new MultiCoreBenchmark();
        bench.warmup();
        int numThreads = Runtime.getRuntime().availableProcessors();
        timer.start();
        bench.run(numThreads);
        long time = timer.stop();
        int score = scorer.getScore(time);
        //log.write("Number of threads used: " +numThreads);
        log.writeTime("Multicore Benchmark finished in", time, Milisecond);
        log.write("Score: " + score);
        log.close();
        flog.write(score);
        flog.close();
        bench.clean();
    }
}
