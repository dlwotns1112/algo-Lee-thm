package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_02224_명제증명_108ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[123][123];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            map[line.charAt(0)][line.charAt(5)] = true;
        }

        for (int k = 65; k < 123; k++) {
            for (int i = 65; i < 123; i++) {
                for (int j = 65; j < 123; j++) {
                    if (map[i][k] && map[k][j] && !map[i][j]) map[i][j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int i = 65; i < 123; i++) {
            for (int j = 65; j < 123; j++) {
                if (i!=j && map[i][j]) {
                    sb.append((char)i).append(" => ").append((char)j).append("\n");
                    answer++;
                }
            }
        }
        System.out.println(answer);
        System.out.println(sb);
    }
}