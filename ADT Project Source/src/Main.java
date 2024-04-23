import GraphGeneration.Generator;
import LCC.LCCStats;

public class Main {
    public static void main(String[] args) {
        var stats = new LCCStats(Generator.generateGraph(10, 0.5f));
        System.out.println("|VLCC| = " + stats.lccVertCount());
        System.out.println("A  Deg = " + stats.lccAvgDeg());
    }
}