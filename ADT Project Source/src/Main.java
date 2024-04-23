import GraphGeneration.Generator;
import LCC.LCC;

public class Main {
    public static void main(String[] args) {
        var g = Generator.generateGraph(10, 0.5f);
        System.out.println("|VLCC| = " + LCC.largestConnectedComponent(g).vertexList.size());
    }
}