package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_01497_기타콘서트_76ms {
    static long[] arr;
    static int answer = 11;
    static int Max = 1;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] musicList = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if (musicList[j] == 'Y') arr[i]+=(Math.pow(2,j));
            }
        }
        for (int i = 0; i < N; i++) {
            start(arr, 1, i, 0, 0);
        }

        System.out.println(answer == 11 ? -1 : answer);
    }

    public static void start(long[] arr, int count, int n, long or, int max) {
        max += count(arr[n] ^ (or & arr[n]));

        or = or | arr[n];

        if (max >= Max) {
            if (max > Max || answer > count) {
                Max = max;
                answer = count;
            }
            if (Max == M) return;
        }

        for (int i = n + 1; i < N; i++) {
            start(arr, count + 1, i, or, max);
        }
        return;
    }

    public static int count(long n) {
        int count = 0;
        while (n != 0){
            n &= (n-1);
            count++;
        }
        return count;
    }
}
