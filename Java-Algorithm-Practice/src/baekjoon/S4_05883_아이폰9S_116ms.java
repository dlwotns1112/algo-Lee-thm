package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S4_05883_아이폰9S_116ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (used.contains(B[i])) continue;
            int target = B[i];
            used.add(target);
            int tempMax = 0;
            int prev = -1;
            int curLength = 1;
            for (int j = 0; j < N; j++) {
                if (B[j] == target) continue;
                else if (B[j] == prev) curLength++;
                else {
                    if (tempMax < curLength) tempMax = curLength;
                    curLength = 1;
                    prev = B[j];
                }
            }
            if (tempMax < curLength) tempMax = curLength;
            if (answer < tempMax) answer = tempMax;
        }
        System.out.println(answer);
    }
}
