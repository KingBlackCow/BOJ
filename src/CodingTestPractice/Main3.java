package CodingTestPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main3 {

    static int  N;
    static String s;

    static boolean is_palindrome() {
        int left = 0, right = N - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    static boolean can_palindrome(int left, int right, boolean skip) {
        if (left > right) return true;
        if (s.charAt(left) == s.charAt(right))
            return can_palindrome(left + 1, right - 1, skip);
        else if (skip)
            return can_palindrome(left + 1, right, false) ?
                    can_palindrome(left + 1, right, false)
                    : can_palindrome(left, right - 1, false);
        else return false;
    }

    static int getAns() {
        if (is_palindrome()) return 0;
        else if (can_palindrome(0, N - 1, true)) return 1;
        else return 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            N = s.length();
            System.out.println(getAns());
        }
    }
}

