/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Tania Ommer, to186@scarletmail.rutgers.edu, to186
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {

		int reviewers = Integer. parseInt(args[0]);
		int movies = Integer.parseInt(args[1]);
		int ratings[][] = new int[reviewers][movies];
		int num = 2;
		int tempsum = 0;
		int sum = 0;
		int index = 0;

		for(int i = 0; i < reviewers; i++){
			for(int j = 0; j < movies; j++){
				if (Integer.parseInt(args[num]) >= 1 && Integer.parseInt(args[num]) <= 5){
				ratings[i][j] = Integer.parseInt(args[num]);
				num++;
				}
				else {
					System.out.println("Error");
					break;
				}
			}
		}

		for(int i = 0; i < movies; i++){
			for(int j = 0; j < ratings.length; j++){
				tempsum += ratings[j][i];
			}
			if(tempsum > sum){
				sum = tempsum;
				tempsum = 0;
				index = i;
			}
			else{
				tempsum = 0;
			}
		}

		System.out.println(index);

	}
}
