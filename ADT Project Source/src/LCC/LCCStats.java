package LCC;

import Data.Graph;

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
}
