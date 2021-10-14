package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=449&sca=20
public class D17_주사위던지기 {
	static int N, M;
	static int[] dice = {1,2,3,4,5,6};
	static int[] answer;
	static boolean[] visit;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[N];
		visit = new boolean[N];
		
		if (M == 1) {
			one(0);
		} else if (M==2) {
			two(0,0);
		} else {
			three(0,0);
		}
		
	}
	
	private static void three(int i, int j) {
		
		
	}

	private static void two(int depth, int length) {
		if (depth == N) {
			System.out.println(Arrays.toString(answer));
			return;
		}
		
		for (int i = length; i<N; i++) {
			answer[depth] = i;
			two(depth+1, i);
		}
		
	}

	static void one(int depth) {
		if (depth == N) {
			System.out.println(Arrays.toString(answer));
			return;
		}
		
		
		for (int i = 0; i < 6; i++) {
			answer[depth] = dice[i];
			one(depth+1);
		}
		
		
		
	}

}
