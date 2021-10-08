package M10;

import java.util.Scanner;

public class D08_N과M2 {
	
	static int N,R;
	static int[] number;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		number = new int[N+1];
		visit = new boolean[N+1];
		
		dfs(1,0);
		
		
	}
	
	static void dfs(int index, int depth) {
		if(depth == R) {
			
			for (int i = 1; i <= N; i++) {
				if(visit[i]) System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		if (index == N+1) return;
		
		visit[index] = true;
		dfs(index+1, depth+1);
		visit[index] = false;
		dfs(index+1, depth);
	}

}
