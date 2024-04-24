import Algorithms.BFS;
import Algorithms.DFS;
import Data.Graph;
import FileIO.GraphReader;
import LCC.LCCStats;


public class Main {
    public static void main(String[] args) {
        Graph downloadedGraph1 = GraphReader.readGraph("DSJC500-5.mtx");
        Graph downloadedGraph2 = GraphReader.readGraph("inf-euroroad.edges");
        Graph downloadedGraph3 = GraphReader.readGraph("inf-power.mtx");


        System.out.println("Computing LCC for DSJC500-5.mtx...");
        var lccStats1 = new LCCStats(downloadedGraph1);
        System.out.println("LCC Vertices of DSJC500-5.mtx: " + lccStats1.lccVertCount());

        System.out.println("Implementing BFS for DSJC500-5.mtx...");
        var BFS1 = BFS.findLongestSimplePath(lccStats1.getLcc());
        System.out.println("BFS Vertices of DSJC500-5.mtx: " + BFS1.size());
        System.out.println("BFS Edges of DSJC500-5.mtx: " + (BFS1.size() - 1));
        System.out.println("Longest Simple Path for DSJC500-5.mtx:");
        System.out.println(BFS1);
        System.out.println("--------------------------------------------");
        System.out.println("Implementing DFS for DSJC500-5.mtx...");
        var DFS1 = DFS.findLongestSimplePath(lccStats1.getLcc());
        System.out.println("DFS Vertices of DSJC500-5.mtx: " + DFS1.size());
        System.out.println("DFS Edges of DSJC500-5.mtx: " + (DFS1.size() - 1));
        System.out.println("Longest Simple Path for DSJC500-5.mtx:");
        System.out.println(DFS1);
        System.out.println("********************************************");


        System.out.println("Computing LCC for inf-euroroad.edges...");
        var lccStats2 = new LCCStats(downloadedGraph2);
        System.out.println("LCC Vertices of inf-euroroad.edges: " + lccStats2.lccVertCount());

        System.out.println("Implementing BFS for inf-euroroad.edges...");
        var BFS2 = BFS.findLongestSimplePath(lccStats2.getLcc());
        System.out.println("BFS Vertices of inf-euroroad.edges: " + BFS2.size());
        System.out.println("BFS Edges of inf-euroroad.edges: " + (BFS2.size() - 1));
        System.out.println("Longest Simple Path for inf-euroroad.edges:");
        System.out.println(BFS2);
        System.out.println("--------------------------------------------");
        System.out.println("Implementing DFS for inf-euroroad.edges...");
        var DFS2 = DFS.findLongestSimplePath(lccStats2.getLcc());
        System.out.println("DFS Vertices of inf-euroroad.edges: " + DFS2.size());
        System.out.println("DFS Edges of inf-euroroad.edges: " + (DFS2.size() - 1));
        System.out.println("Longest Simple Path for inf-euroroad.edges:");
        System.out.println(DFS2);
        System.out.println("********************************************");


        System.out.println("Computing LCC for inf-power.mtx...");
        var lccStats3 = new LCCStats(downloadedGraph3);
        System.out.println("LCC Vertices of inf-power.mtx: " + lccStats3.lccVertCount());

        System.out.println("Implementing BFS for inf-power.mtx...");
        var BFS3 = BFS.findLongestSimplePath(lccStats3.getLcc());
        System.out.println("BFS Vertices of inf-power.mtx: " + BFS3.size());
        System.out.println("BFS Edges of inf-power.mtx: " + (BFS3.size() - 1));
        System.out.println("Longest Simple Path for inf-power.mtx:");
        System.out.println(BFS3);
        System.out.println("--------------------------------------------");
        System.out.println("Implementing DFS for inf-power.mtx...");
        var DFS3 = DFS.findLongestSimplePath(lccStats3.getLcc());
        System.out.println("DFS Vertices of inf-power.mtx: " + DFS3.size());
        System.out.println("DFS Edges of inf-power.mtx: " + (DFS3.size() - 1));
        System.out.println("Longest Simple Path for inf-power.mtx:");
        System.out.println(DFS3);
        System.out.println("********************************************");

    }
}