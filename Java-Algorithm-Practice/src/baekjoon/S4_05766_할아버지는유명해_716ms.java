package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_05766_할아버지는유명해_716ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N; // 2 <= N <= 500
        int M; // 2 <= M <= 500
        int[] playerScore;
        int first;
        int second;
        int max = 0;
        int min = 10001;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            max = 0;
            min = 10001;

            playerScore = new int[10001];
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (max < temp) max = temp;
                    if (min > temp) min = temp;
                    playerScore[temp]++;
                }
            }
            first = second = 1;
            for (int i = min; i <= max; i++) {
                if (playerScore[i] > first) {
                    second = first;
                    first = playerScore[i];
                }
                else if (playerScore[i] > second) {
                    second = playerScore[i];
                }
            }
            for (int i = min; i <= max; i++) {
                if (playerScore[i] == second) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
