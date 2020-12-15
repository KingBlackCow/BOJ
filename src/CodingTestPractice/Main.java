package CodingTestPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.SecureRandom;
import java.util.Stack;

class Main {

//    private static SecureRandom random = new SecureRandom();
//
//    public static String generate(String DATA, int length) {
//        if (length < 1) throw new IllegalArgumentException("length must be a positive number.");
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            sb.append( DATA.charAt(
//                    random.nextInt(DATA.length())
//            ));
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

//            String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";
//            String ENGLISH_UPPER = ENGLISH_LOWER.toUpperCase();
//            int random_string_length=2000;
//
//            //String input = br.readLine();
//            String DATA_FOR_RANDOM_STRING = ENGLISH_LOWER + ENGLISH_UPPER;
//            String input=generate(DATA_FOR_RANDOM_STRING, random_string_length);

            int even = 0;
            if (input.length() % 2 != 0) even++;
            res = 0;

            for (int j = 0; j < input.length() / 2; j++) {
                stack.push(input.charAt(j));
            }
            for (int j = input.length() / 2 + even; j < input.length(); j++) {
                if (stack.pop() != input.charAt(j)) {
                    res++;
                    break;
                }
            }

            if(res!=0)
            {
                boolean sub_res= false;
                for (int k = 0; k < input.length(); k++) {
                    if(sub_res)break;
                    String sub_input=input.substring(0,k)+input.substring(k+1);
                    for (int j = 0; j < sub_input.length() / 2; j++) {
                        stack.push(sub_input.charAt(j));
                    }

                    even = 0;
                    if (sub_input.length() % 2 != 0) even++;

                    for (int j = sub_input.length() / 2 + even; j < sub_input.length(); j++) {
                        if (stack.pop() != sub_input.charAt(j)) {
                                break;
                        }
                        if(j==sub_input.length()-1){
                            sub_res=true;
                        }
                    }
                }
                if(!sub_res)res++;
            }
            System.out.println(res);
        }
    }
}