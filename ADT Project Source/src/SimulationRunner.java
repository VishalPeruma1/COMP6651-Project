import FileIO.GraphReader;
import LCC.LCCStats;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        var stats = new LCCStats(g, canSkipAStar(), g.n, g.r);
        stats.simulate("output_"+filename+"_"+getTime()+".csv");
        System.out.println("Completed Simulation for " + filename);
        counter.incrementAndGet();
    }

    public boolean canSkipAStar() {
        return filename.equals("DSJC500-5.mtx")||filename.equals("inf-euroroad.edges")||filename.equals("inf-power.mtx");
    }

    private static String getTime(){
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // Define the format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - HH-mm-ss");
        // Format the date and time using the formatter
        String formattedDateTime = now.format(formatter);
        // Print the formatted date and time
        return formattedDateTime;
    }
}
