
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Solution implements Runnable{
    @Override
    public void run() {

    }

    static int[][] ary;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int res;
    static class Empl{
        String name="hello~";
        public String toString(){return name;};
    }
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Empl e=new Empl( );

        System.out.println(e);
    }

    private static void dfs(int i, int j) {
        visit[i][j]=true;
        if(i==13&&j==13){
            res=1;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int r = i + dx[k];
            int c = j + dy[k];
            if (!visit[r][c] && ary[r][c] != 1) {
                dfs(r,c);
            }
        }
    }
}