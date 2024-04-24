package LCC;

import Algorithms.BFS;
import Algorithms.DFS;
import AlgorithmsButBetter.AStar;
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
        for(var v1 : getLcc().vertexList){
           for(var v2 : getLcc().vertexList){
               if(v1.equals(v2))
                   continue;
               var o = AStar.lsp(lcc, v1,v2);
               lMax = Math.max(lMax, o);
           }
        }
        return lMax;
    }

    public int lMaxDFS(){
        return DFS.DFSBasedLongestSimplePath(lcc);
    }

    public int lMaxBFS(){
        return BFS.BFSBasedLongestSimplePath(lcc);
    }

    public void simulate(){
        System.out.println("MAX LSP DFS " + lMaxDFS());
        System.out.println("MAX LSP BFS " + lMaxBFS());
    }
}
