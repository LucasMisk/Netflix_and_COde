package Tests;

import Algorithms.*;
import Log.*;
//import Score.*;
import Score.CacheScore;
import Score.RandomAccessScore;
import Score.iScore;
import Timer.*;

public class TestRandomAccess {
    public static void main(String[] args)
    {
        final int ARRAY_SIZE = 1000000; // Adjust the array size according to your needs
        final int ITERATIONS = 1000000000; // Adjust the number of iterations according to your needs
        iTimer timer = new Timer();
        iLog log = new ConsoleLogger();
        iLog flog = new FileLogger("Resources/score.txt");
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        iScore scorer = new RandomAccessScore();

        iBenchmark bench = new RandomAccessBenchmark();
        bench.initialize();
        timer.start();
        bench.run();
        long time = timer.stop();

        int score = scorer.getScore(time);
        log.writeTime("Finished in", time, Milisecond);
        log.write("Score: " + score);
        flog.write(score);
        flog.close();
        log.close();
        bench.clean();
    }
}