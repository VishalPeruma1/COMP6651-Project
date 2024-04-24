import FileIO.GraphReader;
import LCC.LCCStats;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vishnurajendran
 */
public class SimulationRunner implements Runnable {
    String filename;
    AtomicInteger counter;

    public SimulationRunner(String filename, AtomicInteger counter) {
        this.counter = counter;
        this.filename = filename;
    }

    @Override
    public void run() {
        var g = GraphReader.readGraph(filename);
        var stats = new LCCStats(g);
        stats.simulate();
        System.out.println("Completed Simulation for " + filename);
        counter.incrementAndGet();
    }
}
