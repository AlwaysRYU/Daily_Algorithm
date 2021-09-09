package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888_2 {
	static int N;
	static int src[];
	static int op[];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N];
		op = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) src[n] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < 4; n++) op[n] = Integer.parseInt(st.nextToken());
		
		dfs(1 , src[0]);

		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int n, int value) {
		if (n == N) {
			min = Math.min(min, value);
			max = Math.max(max, value);
			return;
		}

		int temp = 0;
		// 연산자 배열만큼 탐색
		for (int i = 0; i < 4; i++) { 
			if (op[i] != 0) {
				op[i]--;
				switch (i) {
				case 0: temp = value + src[n]; break;
				case 1: temp = value - src[n]; break;
				case 2: temp = value * src[n]; break;
				case 3: temp = value / src[n]; break;
				}
				
				dfs(n + 1 , temp);
				op[i]++;
			}
		}
	}
}