package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_16439_치킨치킨치킨_84ms {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(arr, 0, new int[3], N, M, 0);
        System.out.println(answer);
    }
    public static void go(int[][] arr, int count, int[] choice, int N, int M, int start) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int max = arr[i][choice[0]];
                for (int j = 1; j < 3; j++) {
                    if (max < arr[i][choice[j]]) max = arr[i][choice[j]];
                }
                sum += max;
            }
            if (sum > answer) answer = sum;
            return;
        }

        for (int i = start; i < M; i++) {
            choice[count] = i;
            go(arr, count + 1, choice, N, M, i + 1);
        }
    }
}
