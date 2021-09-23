package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20_숨바꼭질 {
	static int N, K;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] field = new int[100001];
		boolean[] visit = new boolean[100001];
		
		Queue<Integer> Q = new LinkedList<>();
		field[N] = 0;
		
		Q.add(N);
		while(!Q.isEmpty()) {
			int now = Q.poll();
			visit[N] = true;
			
			if ( now+1 < 100001 && !visit[now+1]  ) {
				visit[now+1] = true;
				field[now+1] = field[now] + 1;
				Q.add(now+1);
			}
			
			if ( now > 0 && !visit[now-1] ) {
				visit[now-1] = true;
				field[now-1] = field[now] + 1;
				Q.add(now-1);
			}
			
			if ((now*2) < 100001 && !visit[now * 2] ) {
				visit[now * 2] = true;
				field[now * 2] = field[now] + 1;
				Q.add(now * 2);
			}
			
			if (visit[K]) break;
		}
		
		System.out.println(field[K]);
		
		
		
		
	}

}
