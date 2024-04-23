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
      
        System.out.println("N = 300 Computing...");
        var customGen1 = new CustomGeneration(300);
        customGen1.findOptimal(0,1, 0.9f*300, 0.95f*300);

        System.out.println("N = 400 Computing...");
        var customGen2 = new CustomGeneration(400);
        customGen2.findOptimal(0,1, 0.8f*400, 0.9f*400);

        System.out.println("N = 500 Computing...");
        var customGen3 = new CustomGeneration(500);
        customGen3.findOptimal(0,1, 0.7f*500, 0.8f*500);
    }
}