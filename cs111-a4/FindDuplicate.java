/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author: Tania Ommer, to186@scarletmail.rutgers.edu, to186
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {

		int n = args.length;
		int arr[] = new int[n];
		boolean check = false;

		for(int i = 0; i < n; i++){
			if (Integer.parseInt(args[i]) >= 1 && Integer.parseInt(args[i]) <= n){
				arr[i] = Integer.parseInt(args[i]);
			}
		}

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if(arr[i] == arr[j]){
					check = true;
				}
			}
		}
		
		System.out.println(check);

	}
}
