import GraphGeneration.Generator;
import LCC.LCCStats;

/**
 * @author vishnurajendran
 */
public class CustomGeneration {

    private int n;
    public CustomGeneration(int n){
        this.n = n;
    }

    public void findOptimal(float minR, float maxR, float minComp, float maxComp){
        float mid = (minR + maxR)/2;
        LCCStats stats = new LCCStats(Generator.generateGraph(n, mid), false, 0, "-");
        int nodes = stats.lccVertCount();

        if(nodes >= minComp && nodes <= maxComp){
            System.out.println("Found @ N="+n+" and R="+mid);
        }
        else
        {
            if(nodes > maxComp){
                maxR = mid;
            }
            else if(nodes < minComp){
                minR = mid;
            }
            findOptimal(minR, maxR, minComp, maxComp);
        }
    }
}
