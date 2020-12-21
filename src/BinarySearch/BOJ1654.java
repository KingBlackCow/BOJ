package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int have = Integer.parseInt(firstLine[0]); // 가지고 있는 랜선의 개수
        int need = Integer.parseInt(firstLine[1]); // 필요한 랜선의 개수

        int[] len = new int[have];
        for(int i=0; i<have; i++) {
            len[i] = Integer.parseInt(br.readLine()); // 각 랜선의 길이 배열
        }
        Arrays.sort(len);

        long max = len[have-1];
        long min = 0; // 문제에서 랜선 길이는 자연수라 0으로 초기값으로 정하면 에러가 발생한다.
        long middle = 0; // 만약 max에 int의 최대값이 들어가면 처음 middle값은 int 최대의 반인데 그 이상의 수라면 middle은 int를 넘어선다.

        while(max >= min) { // 이분탐색 시작
            middle = (max+min)/2;
            long allCount = 0;
            for(int j=0; j<len.length; j++) {
                allCount += len[j]/middle;
            }
            if(allCount >= need) { // 처음에는 ==이 되면 break를 걸어서 시간을 단축해보려고 했는데, 그건 구체적인 수를 찾을 때는 가능하지만,
                // 문제처럼 가능한 경우의 수 중에서 최대값을 구할 경우에는 다음과 같은 부등호 처리를 해야한다.
                // == 이 아니라도 문제에 답이 되는 경우가 존재하기 때문이다.
                min = middle + 1;
            }else if(allCount < need) {
                max = middle - 1;
            }

        }
        System.out.println(max);

    }

}