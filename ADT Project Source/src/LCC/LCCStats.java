package LCC;

import AlgorithmsButBetter.Dijkstra;
import Data.Graph;
import Data.Vertex;

/**
 * @author vishnurajendran
 */
public class LCCStats {

    private Graph lcc;
    public LCCStats(Graph g){
        lcc = LCC.largestConnectedComponent(g);
    }

    public int lccVertCount(){
        return lcc.vertexList.size();
    }

    public Graph getLcc() {
        return lcc;
    }

    public int lccAvgDeg(){
        return (2*lcc.edgeList.size())/lccVertCount();
    }

    public int maxDeg(){
        int maxDeg = 0;
        for(Vertex v : getLcc().vertexList){
            maxDeg = Math.max(maxDeg, v.getEdgeList().size());
        }
        return maxDeg;
    }

    public int lMaxDijkstra(){
        int lMax = 0;
        for(var vert : getLcc().vertexList){
            var o = Dijkstra.lsp(lcc, vert);
            lMax = Math.max(lMax, o);
        }
        return lMax;
    }

    public int lMaxAStar(){
        int lMax = 0;
        for(var vert : getLcc().vertexList){
            var o = Dijkstra.lsp(lcc, vert);
            lMax = Math.max(lMax, o);
        }
        return lMax;
    }

    public void simulate(){
        System.out.println("MAX LSP " + lMaxAStar());
    }
}
