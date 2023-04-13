package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_01157_단어공부_00ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();;
        line = line.toUpperCase();
        int length = line.length();
        int[] usedNum = new int[91];
        for (int i = 0; i < length; i++) {
            usedNum[line.charAt(i)]++;
        }
        int max = 0;
        char answer = '?';
        for (int i = 65; i < 91; i++) {
            if (usedNum[i] > max) {
                max = usedNum[i];
                answer = (char)i;
            }
            else if (usedNum[i] == max) answer = '?';
        }
        System.out.println(answer);
    }
}
