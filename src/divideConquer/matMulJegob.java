package divideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class matMulJegob {
    static int n;

    public static int[][] matMul(int A[][], int B[][]) {
        int C[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n; l++) {
                for (int j = 0; j < n; j++) {
                    C[i][l] += A[i][j]%1000 * B[j][l]%1000;
                }
            }
        }
        return C;
    }

    static int[][] solution(int[][] C, long m) {
        if (m == 1)
            return C;
        else if (m % 2 == 0) {
            int[][] temp = solution(C, m / 2);
            return matMul(temp, temp);
        } else {
            return matMul(solution(C, m - 1), C);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int A[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] ary = br.readLine().split(" ");
            for (int j = 0; j < ary.length; j++) {
                A[i][j] = Integer.parseInt(ary[j]);
            }
        }

        int C[][] = new int[n][n];
        C = solution(A, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }
}