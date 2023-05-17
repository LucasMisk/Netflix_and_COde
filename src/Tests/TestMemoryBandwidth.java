package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.CacheScore;
import Score.iScore;
import Timer.*;

public class TestMemoryBandwidth {
    public static void main(String[] args)
    {
        final int ARRAY_SIZE = 100000000; // Adjust this value based on available memory
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new CacheScore();

        iBenchmark bench = new MemoryBandwidthBenchmark();
        bench.initialize();
        timer.start();
        bench.run();
        long time = timer.stop();
        // Calculate elapsed time in seconds
        double elapsedTime = time / 1_000_000_000.0;

        // Calculate memory bandwidth in GB/s
        long dataSize = (long) ARRAY_SIZE * Integer.BYTES;
        double bandwidth = dataSize / (elapsedTime * 1_073_741_824.0);

        System.out.println("Memory Bandwidth: " + bandwidth + " GB/s");
        //int score = scorer.getScore(time);
        log.writeTime("Finished in", time, Milisecond);
        //log.write("Score: " + score);
        //flog.write(score);
        flog.close();
        log.close();
        bench.clean();
    }
}