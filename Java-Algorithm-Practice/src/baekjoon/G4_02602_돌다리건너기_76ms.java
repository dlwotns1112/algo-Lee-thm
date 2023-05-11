package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_02602_돌다리건너기_76ms {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String devil = br.readLine();
        String angel = br.readLine();
        int targetSize = target.length();
        int bridgeSize = devil.length();
        long[][][] dp = new long[2][bridgeSize][targetSize];
        dp[0][0][0] = devil.charAt(0) == target.charAt(0) ? 1 : 0;
        dp[1][0][0] = angel.charAt(0) == target.charAt(0) ? 1 : 0;
        for (int i = 1; i < bridgeSize; i++) {
            char angelCur = angel.charAt(i);
            char devilCur = devil.charAt(i);
            dp[0][i][0] = devilCur == target.charAt(0) ? dp[0][i - 1][0] + 1 : dp[0][i - 1][0];
            dp[1][i][0] = angelCur == target.charAt(0) ? dp[1][i - 1][0] + 1 : dp[1][i - 1][0];
            for (int j = 1; j < targetSize; j++) {
                dp[0][i][j] = devilCur == target.charAt(j) ? dp[0][i - 1][j] + dp[1][i - 1][j - 1] : dp[0][i - 1][j];
                dp[1][i][j] = angelCur == target.charAt(j) ? dp[1][i - 1][j] + dp[0][i - 1][j - 1] : dp[1][i - 1][j];
            }
        }
        System.out.println(dp[0][bridgeSize - 1][targetSize - 1] + dp[1][bridgeSize - 1][targetSize - 1]);
    }
}