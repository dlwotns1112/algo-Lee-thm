package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class S4_05766_할아버지는유명해_1376ms {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N; // 2 <= N <= 500
        int M; // 2 <= M <= 500
        TreeMap<Integer, Integer> playerScoreMap = new TreeMap<>();
        int first;
        int second;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            playerScoreMap.clear();
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (playerScoreMap.containsKey(temp)) playerScoreMap.put(temp, playerScoreMap.get(temp) + 1);
                    else playerScoreMap.put(temp, 1);
                }
            }
            first = second = 1;
            for (Map.Entry<Integer, Integer> entry : playerScoreMap.entrySet()) {
                if (entry.getValue() > first) {
                    second = first;
                    first = entry.getValue();
                }
                else if (entry.getValue() > second)
                    second = entry.getValue();
            }
            for (Map.Entry<Integer, Integer> entry : playerScoreMap.entrySet()) {
                if (entry.getValue() == second)
                    sb.append(entry.getKey()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
