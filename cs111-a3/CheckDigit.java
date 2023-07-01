/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author:
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {

        int sum1 = 0;
        int sum2 = 0;
        int step = 1;

        long num = Long.parseLong(args[0]);

        while(num > 0){
            if(step % 2 == 0){
                sum2 += num % 10;
            }
            else{
                sum1 += num % 10;
            }
            num /= 10;
            step++;
        }

        sum1 = sum1 % 10;
        sum2 = sum2 % 10;

        sum2 = sum2 * 3;
        sum2 = sum2 % 10;

        int sum = sum1 + sum2;
        sum %= 10;
        System.out.println(sum);

    }
}