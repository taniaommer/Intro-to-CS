/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author: Tania Ommer, to186@scarletmail.rutgers.edu, to186
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {

	if(n == 0){
        return original;
    }
        return original + appendNTimes(original, n - 1);
    }

    public static void main (String[] args) {

	System.out.print(appendNTimes("cat", 6));

    }
}
