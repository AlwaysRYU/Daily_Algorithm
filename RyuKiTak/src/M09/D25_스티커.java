package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15662
public class D25_스티커 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n+1];
			int[][] answer = new int[2][n+1];
			
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 1; k <=  n; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력완료
			answer[0][1] = sticker[0][1];
			answer[1][1] = sticker[1][1];
			for (int j = 2; j <= n; j++) {
				answer[0][j] = Math.max(answer[1][j-1], answer[1][j-2]) + sticker[0][j];
				answer[1][j] = Math.max(answer[0][j-1], answer[0][j-2]) + sticker[1][j];
			}
			System.out.println(Math.max(answer[0][n], answer[1][n]));
			
		}
	}

}
