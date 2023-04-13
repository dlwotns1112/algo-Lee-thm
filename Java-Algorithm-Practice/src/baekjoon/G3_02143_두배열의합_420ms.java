package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G3_02143_두배열의합_420ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        HashMap<Integer, Integer> subArr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (!subArr.containsKey(A[i])) {
                subArr.put(A[i], 1);
            }
            else subArr.put(A[i], subArr.get(A[i]) + 1);
            for (int j = 0; j < i; j++) {
                A[j] += A[i];
                if (!subArr.containsKey(A[j])) {
                    subArr.put(A[j], 1);
                }
                else subArr.put(A[j], subArr.get(A[j]) + 1);
            }
        }

        long answer = 0;
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            if (subArr.containsKey(T - B[i])) {
                answer += subArr.get(T - B[i]);
            }
            for (int j = 0; j < i; j++) {
                B[j] += B[i];
                if (subArr.containsKey(T - B[j])) {
                    answer += subArr.get(T - B[j]);
                }
            }
        }

        System.out.println(answer);
    }
}
