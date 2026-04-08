package practica1;
import java.util.Scanner;

public class examp5 {
    static int calculateFactorial(int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(calculateFactorial(num));

        scan.close();
    }
}
