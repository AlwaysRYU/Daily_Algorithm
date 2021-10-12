package dynnamic;

import java.util.*;
import java.io.*;

public class 백준_전깃줄 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int kg = Integer.parseInt(st.nextToken());
		ArrayList<int[]> product = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int happy = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; count > 0; j++) {
				int tmp = Math.min(1 << j, count);
				int curWeight = weight * tmp;
				int curHappy = happy * tmp;
				product.add(new int[] { curWeight, curHappy });
				count -= tmp;
			}
		}
		int curN = product.size();
		int dp[][] = new int[curN+1][kg + 1];
		for (int i = 1; i <= curN; i++) {
			for (int j = 1; j <= kg; j++) {
				if (j >= product.get(i-1)[0]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - product.get(i-1)[0]] + product.get(i-1)[1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[curN][kg]);
	}
}