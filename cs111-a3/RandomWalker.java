/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author: Tania Ommer, to186@scarletmail.rutgers.edu, to186
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

	int steps = Integer.parseInt(args[0]);

    int x = 0;
    int y = 0;

    System.out.println("(" + x + ", " + y + ")");

    for(int i = 0; i < steps; i++){
        double random = Math.random();
        if (random < 0.25){
            x++;
        }
        else if(random < 0.5){
            y--;
        }
        else if(random < 0.75){
            x--;
        }
        else if(random < 1.0){
            y++;
        }

        System.out.println("(" + x + ", " + y + ")");
    }
    System.out.println("Squared distance = " + (Math.pow(x, 2) + Math.pow(y, 2)));

    }
}
