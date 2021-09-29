package BOJ;

import java.util.Scanner;

public class 오르막수_11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][10];
		
		for (int i = 0; i <= 9; i++) dp[1][i] = 1;
		
		for (int i = 2; i <= N; i++)
			for (int j = 0; j <= 9; j++)
				for (int k = j; k <= 9; k++)
					dp[i][k] = (dp[i][k] + dp[i - 1][j]) % 10007;

		int ans = 0;
		for (int i = 0; i <= 9; i++) ans += dp[N][i];
		ans %= 10007;
		
		System.out.println(ans);
	}
}
