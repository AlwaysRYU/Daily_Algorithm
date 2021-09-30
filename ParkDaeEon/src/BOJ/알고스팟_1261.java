package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟_1261 {
	static int M, N;
	static char[][] map;
	static int[][] cost;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static Queue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		cost = new int[N][M];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dijkstra();
		
		System.out.println(cost[N-1][M-1]);
	}

	static void dijkstra() {
		cost[0][0] = map[0][0] - '0';
		pq.offer(new Edge(0, 0, map[0][0] - '0'));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = e.y + dy[i];
				int nx = e.x + dx[i];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				
				int c = map[ny][nx] - '0';
				if (e.c + c < cost[ny][nx]) {
					cost[ny][nx] = e.c + c;
					pq.offer(new Edge(ny, nx, cost[ny][nx]));
				}
			}
		}
	}

	static class Edge {
		int x, y, c;

		public Edge(int y, int x, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
