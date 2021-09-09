package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 완전 탐색
 */
public class 연산자끼워넣기_14888 {
	static int N, min, max;
	static int[] numbers;
	static boolean[] check;
	static char[] ops;
	static char[] tgt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		ops = new char[N - 1];
		tgt = new char[N - 1];
		check = new boolean[N - 1];
		
		st = new StringTokenizer(br.readLine());
		
		// 연산자 배열에 해당 연산자 개수만큼 연산자 초기화
		int index = 0;
		int temp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < temp; i++) ops[index++] = '+';
		temp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < temp; i++) ops[index++] = '-';
		temp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < temp; i++) ops[index++] = '*';
		temp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < temp; i++) ops[index++] = '/';
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		perm(0, numbers[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void perm(int tgtIdx, int value) {
		
		if (tgtIdx == N - 1) {	
			min = Math.min(min, value);
			max = Math.max(max, value);
			return;
		}
		
		for (int i = 0; i < N - 1; i++) {
			if (check[i]) continue;
			check[i] = true;
			tgt[tgtIdx] = ops[i];
			
			int curValue = value;
			switch (ops[i]) {
			case '+': curValue += numbers[tgtIdx + 1]; break;
			case '-': curValue -= numbers[tgtIdx + 1]; break;
			case '*': curValue *= numbers[tgtIdx + 1]; break;
			case '/': curValue /= numbers[tgtIdx + 1]; break;
			}

			perm(tgtIdx + 1, curValue);
			
			check[i] = false;
		}
	}
}
