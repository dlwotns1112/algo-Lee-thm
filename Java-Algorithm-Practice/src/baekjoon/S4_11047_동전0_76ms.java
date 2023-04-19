package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_11047_동전0_76ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int end = N;
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i]>K) {
                end = i;
                break;
            }
        }
        int answer = 0;
        for (int i = end -1; i > -1 ; i--) {
            answer += K / coins[i];
            K %= coins[i];
            if (K == 0) break;
        }
        System.out.println(answer);
    }
}
