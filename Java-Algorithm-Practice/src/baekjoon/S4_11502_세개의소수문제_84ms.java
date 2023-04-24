package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_11502_세개의소수문제_84ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[1000];
        prime[0] = prime[1] = true;
        for (int i = 2; i < 1000; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < 1000; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            for (int i = K - 4; i > 1 ; i--) {
                if (prime[i]) continue;
                int temp = K - i;
                for (int j = temp - 2; j > 1; j--) {
                    if (prime[j]) continue;
                    int temp2 = temp - j;
                    if (!prime[temp2]) {
                        sb.append(temp2).append(" ").append(j).append(" ").append(i).append("\n");
                        i = j = 0;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
