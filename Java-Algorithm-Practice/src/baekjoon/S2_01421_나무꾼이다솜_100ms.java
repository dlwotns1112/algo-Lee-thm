package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_01421_나무꾼이다솜_100ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] woods = new int[N];
        int maxlength = 0;
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(br.readLine());
            if (woods[i] > maxlength) maxlength = woods[i];
        }

        long max = 0;
        for (int standard = 1; standard <= maxlength; standard++) {
            long benefit = 0;
            for (int j = 0; j < N; j++) {
                if (woods[j] >= standard){
                    int count = woods[j]/standard;
                    int temp = count * standard * W - count * C;
                    if (woods[j]%standard == 0) {
                        temp += C;
                    }
                    if (temp > 0) benefit += temp;
                }
            }
            if (max < benefit) {
                max = benefit;
            }
        }
        System.out.println(max);
    }
}
