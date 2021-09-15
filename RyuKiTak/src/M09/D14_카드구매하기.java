package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11052
public class D14_카드구매하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] Card = new int[N+1];
		int[] Money = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			Card[i] = Integer.parseInt(st.nextToken());
		}
		Money[1] = Card[1];
		for (int i = 2; i <= N; i++) {
			
			// 1개 부터 
			for (int j = 1; j <= i; j++) {
				Money[i] = Math.max(Money[i], Card[j] + Money[i-j]);
			}
			
		}
		System.out.println(Money[N]);
		
	}

}
