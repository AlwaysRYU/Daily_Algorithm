package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Queue<Fish> pq = new PriorityQueue<>((a, b) -> 
			a.dist != b.dist ? a.dist - b.dist :
				a.y != b.y ? a.y - b.y : a.x - b.x);
	static Whale w;

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (1 <= n && n <= 6) {
					map[i][j] = n;
				} else if (n == 9) {
					w = new Whale(i, j);
				}
			}
		}
		
		// 현재 상어의 위치에서 먹을 수 있는 물고기를 우선순위 큐에 저장한다.
		while (true) {
			bfs();
			
			if (pq.size() == 0) break;
			
			else {
				Fish cur = pq.poll();
				w.x = cur.x;
				w.y = cur.y;
				w.sec += cur.dist;
				w.eat();
				map[cur.y][cur.x] = 0;
			}
		}
		System.out.println(w.sec);
	}
	
	static void bfs() {
		int y = w.y;
		int x = w.x;
		boolean visit[][] = new boolean[N][N];
		Queue<Fish> q = new LinkedList<>();
		q.add(new Fish(y, x, 0));
		visit[y][x] = true;
		pq.clear();
		
		while (!q.isEmpty()) {
			Fish cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				// 지도 밖 OR 이미 방문 OR 아기 상어보다 큰 물고기
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if (visit[ny][nx] || map[ny][nx] > w.size) continue;
				
				visit[ny][nx] = true;
				q.add(new Fish(ny, nx, cur.dist + 1));
				
				// 먹을 수 있는 물고기이면
				if (1 <= map[ny][nx] && map[ny][nx] < w.size) {
					pq.offer(new Fish(ny, nx, cur.dist + 1));
				}
			}
		}
	}
	
	static class Whale {
		int y, x;
		int size;
		int eatCount;
		int sec;
		Whale(int y, int x) {
			this.y = y;
			this.x = x;
			this.size = 2;
		}
		void eat() {
			eatCount++;
			if (eatCount == size) {
				size++;
				eatCount = 0;
			}
		}
	}
	
	static class Fish {
		int y, x;
		int dist;
		public Fish(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}
