package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_05577_1학년_76ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] count = new long[21];
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        count[numbers[0]]++;
        long[] tempCount;
        for (int i = 1; i < N - 1; i++) {
            tempCount = new long[21];
            for (int j = 0; j < 21; j++) {
                if (count[j] != 0) {
                    if (j + numbers[i] < 21)  tempCount[j + numbers[i]] += count[j];
                    if (j - numbers[i] > -1)  tempCount[j - numbers[i]] += count[j];
                }
            }
            for (int j = 0; j < 21; j++) {
                count[j] = tempCount[j];
            }
        }
        System.out.println(count[numbers[N - 1]]);
    }
}
