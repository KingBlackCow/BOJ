

import java.io.*;
import java.util.*;

public class Main2 {

    static int factorial(int n){
        if(n==1||n==0)return 1;
        else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

    }
}


