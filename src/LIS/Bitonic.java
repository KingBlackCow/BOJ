package LIS;
import java.util.Scanner;
public class Bitonic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ary[] = new int[n];
        int lis[] = new int[n];
        int lds[] = new int[n];

        for(int i=0;i<n;i++) {
            ary[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++) {
            lis[i] = 1;
            for(int j=0;j<i;j++) {
                if(ary[j]<ary[i] && lis[i] < lis[j]+1) {
                    lis[i] = lis[j]+1;
                }
            }
        }

        for(int i=n-1;i>=0;i--) {
            lds[i] = 1;

            for(int j=n-1;j>i;j--) {
                if(ary[j]<ary[i] && lds[i] < lds[j]+1) {
                    lds[i] = lds[j]+1;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            if(max<lis[i]+lds[i]) {
                max = lis[i] + lds[i];
            }
        }
        System.out.println(max - 1);
        sc.close();
    }
}