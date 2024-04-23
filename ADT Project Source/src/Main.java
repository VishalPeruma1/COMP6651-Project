import Data.Graph;
import FileIO.GraphReader;
import FileIO.GraphSaver;
import GraphGeneration.Generator;
import LCC.LCC;
import LCC.LCCStats;

public class Main {
    public static void main(String[] args) {
        Graph downloadedGraph1 = GraphReader.readGraph("DSJC500-5.mtx");
        Graph downloadedGraph2 = GraphReader.readGraph("inf-euroroad.edges");
        Graph downloadedGraph3 = GraphReader.readGraph("inf-power.mtx");

        var cg = new CustomGeneration(300);
        cg.findOptimal(0,1,(0.9f*300),(0.95f*300));

        System.out.println("Computing LCC for DSJC500-5.mtx...");
        var lccStats1 = new LCCStats(downloadedGraph1);
        System.out.println("LCC Vertices of DSJC500-5.mtx: " + lccStats1.lccVertCount());

        System.out.println("Computing LCC for inf-euroroad.edges...");
        var lccStats2 = new LCCStats(downloadedGraph2);
        System.out.println("LCC Vertices of inf-euroroad.edges: " + lccStats2.lccVertCount());

        System.out.println("Computing LCC for inf-power.mtx...");
        var lccStats3 = new LCCStats(downloadedGraph3);
        System.out.println("LCC Vertices of inf-power.mtx: " + lccStats3.lccVertCount());

    }
}