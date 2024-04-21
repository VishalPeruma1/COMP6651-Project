package Data;

/**
 * @author vishnurajendran
 */
public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj.getClass() != Vector2.class)
           return false;

       var other = (Vector2)obj;
       return other.x == x && other.y == y;
    }

    public static Vector2 zero() {return new Vector2(0,0);}
    public static double euclidianDistance(Vector2 v1, Vector2 v2) {
        var xSquared = Math.pow((v1.x - v2.x),2);
        var ySquared = Math.pow((v1.x - v2.x),2);
        return Math.sqrt(xSquared + ySquared);
    }
}
