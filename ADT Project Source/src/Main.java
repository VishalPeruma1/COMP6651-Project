import Data.Graph;
import FileIO.GraphReader;
import FileIO.GraphSaver;
import GraphGeneration.Generator;
import LCC.LCCStats;

public class Main {
    public static void main(String[] args) {
        Graph downloadedGraph1 = GraphReader.readGraph("DSJC500-5.mtx");
        Graph downloadedGraph2 = GraphReader.readGraph("inf-euroroad.edges");
        Graph downloadedGraph3 = GraphReader.readGraph("inf-power.mtx");
        var stats = new LCCStats(Generator.generateGraph(10, 0.5f));
        System.out.println("|VLCC| = " + stats.lccVertCount());
        System.out.println("A  Deg = " + stats.lccAvgDeg());
    }
}