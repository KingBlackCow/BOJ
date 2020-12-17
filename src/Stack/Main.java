package Stack;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        while (true) {
            String str = br.readLine();
            if (str.charAt(0) == '.') break;
            int n = 0;
            stack = new Stack<Character>();
            boolean res = true;
            while (str.charAt(n) != '.') {
                if (str.charAt(n) == '(' || str.charAt(n) == '[') {
                    stack.push(str.charAt(n));
                } else if (str.charAt(n) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        res = false;
                        break;
                    }
                } else if (str.charAt(n) == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        res = false;
                        break;
                    }
                }
                n++;
            }
            if(!stack.isEmpty())res=false;
            if (res) System.out.println("yes");
            else {
                System.out.println("no");
            }
        }
    }
}


