package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Timer.*;

public class TestCache {
    public static void main(String[] args)
    {
        final int workload=100000000;
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;

        iBenchmark bench = new CacheBenchmark();
        bench.initialize(workload);
        bench.warmup();
        timer.start();
        bench.run();
        long time = timer.stop();
        log.writeTime("Finished in", time, Milisecond);
        log.close();
        bench.clean();
    }
}