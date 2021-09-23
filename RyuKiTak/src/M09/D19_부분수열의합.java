package M09;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 이것도 시간초과 난다.
public class D19_부분수열의합 {
	static int N, S;
	static int[] arr;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		check = new boolean[N];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			HAP(0,0,i,0);				
		}
		System.out.println(answer);
	
	}
	
	static boolean check[];
	public static void HAP(int index, int sum, int R,int count) {
		if ( count == R) {
//			for (int i = 0; i < N; i++) {
//				if (check[i]) System.out.print(arr[i] + " ");
//			}
//			System.out.println(" --> 합:" + sum);
			if (sum == S) answer += 1;
			return;
		}
		
		if ( index == N ) return;
		check[index] = true;
		HAP(index+1, sum+arr[index], R,count+1);
		check[index] = false;
		HAP(index+1, sum, R, count);
		
	}

}
