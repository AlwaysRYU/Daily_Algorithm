package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11404

public class D02_Q37플로이드 {
	static int N, M;
	static int[][] field;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int infinite = 9999999; // 맥스로 주면틀린다.
		field = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				// 일단 기본적으로 무한
				field[i][j] = infinite;
				if (i==j) field[i][j] = 0; 
			}
		}
		
		M = Integer.parseInt(br.readLine());
	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int For = Integer.parseInt(st.nextToken());
			int To = Integer.parseInt(st.nextToken());
			int Cost = Integer.parseInt(st.nextToken());
			if (Cost < field[For][To]) field[For][To] = Cost;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				for (int j2 = 1; j2 < N+1; j2++) {
					field[j][j2] = Math.min(field[j][j2], field[j][i] + field[i][j2]);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if (field[i][j] == infinite) System.out.print(0 + " ");
				else System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}
	
	
	}

}
