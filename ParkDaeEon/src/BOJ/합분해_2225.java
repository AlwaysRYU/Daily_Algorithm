package BOJ;

import java.util.Scanner;

public class 합분해_2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		int[][] dp = new int[K + 1][N + 1];
		
		for (int i = 0; i <= K; i++) dp[i][0] = 1;
		
		for (int i = 1; i <= K; i++)
			for (int j = 1; j <= N; j++)
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;

		System.out.println(dp[K][N]);
	}
}