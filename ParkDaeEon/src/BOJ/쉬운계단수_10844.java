package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for (int i = 1; i <= 9; i++) dp[1][i] = 1;
		int nr = 1, cr = 0;
		for (int i = 2; i <= N; i++) {
			nr = i % 2;
			cr = (i + 1) % 2;
			dp[nr][0] = dp[cr][1];
			for (int j = 1; j <= 8; j++) {
				dp[nr][j] = (dp[cr][j - 1] + dp[cr][j + 1]) % 1000000000;
			}
			dp[nr][9] = dp[cr][8];
		}
		int ans = 0;
		for (int i = 0; i <= 9; i++) ans = (ans + dp[nr][i]) % 1000000000;
		System.out.println(ans);
	}
}
