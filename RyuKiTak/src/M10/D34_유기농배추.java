package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D34_유기농배추 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, K;
	static int[][] field;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int Test = Integer.parseInt(br.readLine());
		for (int ttt = 0; ttt < Test; ttt++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			field = new int[N][M];
			visit = new boolean[N][M];
			
			// 위치 개수 
			K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				field[x][y] = 1;
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//			
//				System.out.print(field[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if ( field[i][j] == 1 && !visit[i][j] ) {
						DFS(i,j);
						count += 1;
					}	
				}
			}
			
			bw.append(Integer.toString(count) + "\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	static int[] dx = { -1, 0, 0, 1};
	static int[] dy = { 0, 1, -1, 0};
	private static void DFS(int x, int y) {
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (  nx<0 || ny<0 || nx >= N || ny >= M  || visit[nx][ny] 
					|| field[nx][ny] == 0) {
				continue;
			}
			DFS(nx,ny);
			
		}
	
	}

}
