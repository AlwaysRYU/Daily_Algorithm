package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D07_연산자끼워넣기 {
	static int Maxx = Integer.MIN_VALUE;
	static int Minn = Integer.MAX_VALUE;
	static boolean[] check;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int[] giho = new int[N-1];
		check = new boolean[N-1];
		
		// + - X / 0 1 2 3 
		int index = 0;
		for (int i = 0; i < 4; i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				giho[index] = i;
				index += 1;
			}
		}
		
		// ㄱㄱ
		
		dfs(N-1, 0, arr[0], giho, 1);
		
		System.out.println(Maxx);
		System.out.println(Minn);
	}
	
	static void dfs(int total, int count, int sum, int[] gihoarr, int index ) {
		
		if ( count == total ) {
			Maxx = Integer.max(sum, Maxx);
			Minn = Integer.min(sum, Minn);
			return;
		}
		
		for (int i = 0; i < gihoarr.length; i++) {
			if (check[i]) continue;
			
			check[i] = true;
			if (gihoarr[i] == 0) {
				// +
				dfs(total, count+1, sum+arr[index], gihoarr, index + 1);
			} else if ( gihoarr[i] == 1) {
				// -
				dfs(total, count+1, sum-arr[index], gihoarr, index + 1);
				
			} else if ( gihoarr[i] == 2) {
				// X
				dfs(total, count+1, sum*arr[index], gihoarr, index + 1);
				
			} else if ( gihoarr[i] == 3) {
				// /

				dfs(total, count+1, sum/arr[index], gihoarr, index + 1);
				
			}
			
			check[i] = false;
			
			
			
		}
		
		
	}

}