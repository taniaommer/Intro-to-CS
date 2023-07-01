/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author: Tania Ommer, to186@scarletmail.rutgers.edu, to186
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {
        double arr[] = new double[array.length];
        for(int i = 0; i < array.length; i++){
            arr[i] = array[i];
        }
        return arr;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {
        for(int i = 0; i < x.length; i++){
            x[i] *= alpha;
        }
        for(int j = 0; j < x.length; j++){
            y[j] *= alpha;
        }
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for(int i = 0; i < x.length; i++){
            x[i] += dx;
        }
        for(int j = 0; j < x.length; j++){
            y[j] += dy;
        }
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {
        for(int i = 0; i < x.length; i++){
            double newX = (x[i] * Math.cos(Math.toRadians(theta))) - (y[i] * Math.sin(Math.toRadians(theta)));
            double newY = (y[i] * Math.cos(Math.toRadians(theta))) + (x[i] * Math.sin(Math.toRadians(theta)));
            x[i] = newX;
            y[i] = newY;
        }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {

    }
}
