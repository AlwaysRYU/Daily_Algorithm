package BOJ;

import java.util.Scanner;

public class 카드구매하기_11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		
		// n 개의 카드를 구매할 때 : n - k개의 카드를 구매했을 때의 최대비용과 k개를 구입했을 때의 비용의 합을 비교한다.
		for (int n = 1; n <= N; n++)
			for (int k = 1; k <= n; k++)
				dp[n] = Math.max(dp[n], dp[n - k] + arr[k]);
		System.out.println(dp[N]);
	}
}
