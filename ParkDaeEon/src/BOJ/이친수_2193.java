package BOJ;

import java.util.Scanner;

public class 이친수_2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		long dp[][] = new long[N + 1][2];
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 0;
		for (int i = 3; i <= N; i++) {
			dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
			dp[i][1] = dp[i - 1][0];
		}
		long ans = dp[N][0] + dp[N][1];
		System.out.println(ans);
	}
}