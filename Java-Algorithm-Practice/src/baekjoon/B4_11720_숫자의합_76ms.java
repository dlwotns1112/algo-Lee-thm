package baekjoon;

import java.io.*;

public class B4_11720_숫자의합_76ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String line = br.readLine();
        while(N-- > 0) {
            answer += line.charAt(N) - '0';
        }
        System.out.println(answer);
    }
}

