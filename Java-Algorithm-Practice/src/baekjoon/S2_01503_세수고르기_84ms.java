package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_01503_세수고르기_84ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        boolean[] arr = new boolean[1002];

        for (int i = 0; i < M; i++)
            arr[Integer.parseInt(st.nextToken())] = true;

        int min = 999999999;
        for (int i = 1; i < 1001; i++){
            if (arr[i]) continue;
            for (int j = i; j < 1001; j++){
                if (arr[j]) continue;
                int temp1 = i * j;
                if (temp1 > N && min < temp1 - N) break;
                for (int k = j; k < 1002; k++){
                    if (arr[k]) continue;
                    int temp2 = temp1 * k;
                    if (temp2 > N && min < temp2 - N) break;
                    if (min > Math.abs(N - temp2)) min = Math.abs(N - temp2);
                }
            }
        }
        System.out.println(min);
    }
}
