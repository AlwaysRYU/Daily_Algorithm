package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1261
public class D30_알고스팟 {
	static int N,M;
	static int[][] field;
	static boolean[][][] visit;
	static int answer = Integer.MAX_VALUE;
	static class Node {
		int x;
		int y;
		int broken;
		
		public Node(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		visit = new boolean[N][M][10001];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				field[i][j] = temp.charAt(j) - '0';
			}
		}
		
		
		visit[0][0][0] = true;
		bfs(0,0);
		System.out.println(answer);
	}
	
	
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, 1, 0, -1};
	static void bfs(int x, int y) {
		
		Queue<Node> Q = new LinkedList<>();
		Q.add(new Node(x,y,0));
		while( !Q.isEmpty() ) {
			
			Node now = Q.poll();
			if (now.x == N-1 && now.y == M-1 ) {
				// 도착지점
				answer = Math.min(answer, now.broken);
				continue;
			}
			if (now.broken >= answer ) continue;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if ( nx<0 || ny<0 || nx >= N || ny >= M ) continue;
				
				if ( field[nx][ny] == 0 ) {
					if (visit[nx][ny][now.broken] == false ) {
						visit[nx][ny][now.broken] = true;
						Q.add(new Node(nx,ny,now.broken));
					}
				} else {
					// 벽이면
					if (visit[nx][ny][now.broken+1] == false ) {
						visit[nx][ny][now.broken+1] = true;
						Q.add(new Node(nx,ny,now.broken+1));
					}
					
				}
				
				
			}
		}
		
		
	}

}
