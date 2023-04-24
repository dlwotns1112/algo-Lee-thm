package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S4_11502_세개의소수문제_240ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[1000];
        prime[0] = prime[1] = true;
        HashSet<Integer> primeSet = new HashSet<>();
        for (int i = 2; i < 1000; i++) {
            if (!prime[i]) {
                primeSet.add(i);
                for (int j = i + i; j < 1000; j += i) {
                    prime[j] = true;
                }
            }
        }
        Integer[] primeArr = primeSet.stream().sorted().toArray(Integer[] :: new);
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < primeArr.length; i++) {
                int temp = K - primeArr[i];

                for (int j = 0; j < primeArr.length; j++) {
                    int temp2 = temp - primeArr[j];
                    if (temp2 < 2) break;
                    if (!prime[temp - primeArr[j]]) {
                        sb.append(primeArr[i]).append(" ").append(primeArr[j]).append(" ").append(temp - primeArr[j]).append("\n");
                        i = j = primeSet.size();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
