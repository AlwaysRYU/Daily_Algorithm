package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;

	static int[] dy = { 1, 0, -1,  0 };
	static int[] dx = { 0, 1,  0, -1 };
	static int[] hdy = { 1,  1, -2, -2, -1, -1, 2,  2 };
	static int[] hdx = { 2, -2,  1, -1,  2, -2, 1, -1 };

	static Queue<Node> q = new LinkedList<>();
	
	static class Node {
		int y, x, k, d;

		public Node(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visit = new boolean[H][W][K + 1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}

		Node n = new Node(0, 0, K, 0);
		visit[0][0][K] = true;
		q.offer(n);
		bfs();
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node node = q.poll();
		
			if (node.y == H - 1 && node.x == W - 1) {
				System.out.println(node.d);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k]) continue;
				
				visit[ny][nx][node.k] = true;
				q.offer(new Node(ny, nx, node.k, node.d + 1));
			}
			
			if (node.k > 0) {
				for (int i = 0; i < 8; i++) {
					int ny = node.y + hdy[i];
					int nx = node.x + hdx[i];
					if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1]) continue;
					
					visit[ny][nx][node.k - 1] = true;
					q.offer(new Node(ny, nx, node.k - 1, node.d + 1));
				}
			}
		}
		System.out.println(-1);
	}
}
