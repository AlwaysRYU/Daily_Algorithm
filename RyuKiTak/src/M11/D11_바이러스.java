package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2606
public class D11_바이러스 {
	static int N; // 컴퓨터 개수
	static int M; // 쌍개수
	static boolean[][] route;
	static boolean[] visit;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		route = new boolean[N][N];
		visit = new boolean[N];
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			route[A][B] = true;
			route[B][A] = true;
			
			
		}

		visit[0] = true;
		virus(0);
		
		System.out.println(answer);
	}
	
	static void virus(int index) {
		//System.out.println((index+1) + " 방문함 ");
		for (int i = 0; i < N; i++) {
			if ( visit[i] == false && route[index][i] ) {
				// 길이 있는 경우에만
				visit[i] = true;
				answer += 1;
				virus(i);
			}
		}
	}

}
