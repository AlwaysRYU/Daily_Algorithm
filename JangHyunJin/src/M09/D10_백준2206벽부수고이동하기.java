package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2206벽부수고이동하기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][][] visited;
	static int N, M;
	static boolean flag = false;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		visited = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			map[i] = bf.readLine().toCharArray();
//			System.out.println(Arrays.toString(map[i]));
		}
		visited[0][0][0] = true;
		bfs(0, 0, 1);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void bfs(int y, int x, int t) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(y, x, t,0));
		int ny, nx;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int cnt = p.cnt;
			if(p.y==N-1 && p.x==M-1) 
			{
				if(ans>cnt)ans = cnt;
				continue;
			}
			if (ans <= cnt)continue;
			
			for (int i = 0; i < 4; i++) {
				
				ny = p.y + dy[i];
				nx = p.x + dx[i];
				
				if (!isRange(ny, nx))
					continue;
				
				if(p.flag==0 && map[ny][nx]=='1') {
					q.offer(new Pair(ny,nx,cnt+1,1));
					continue;
				}
				
				if(!visited[p.flag][ny][nx] && map[ny][nx]=='0') {
					visited[p.flag][ny][nx] = true;
					q.offer(new Pair(ny,nx,cnt+1,p.flag));
				}
			}
		}
	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return false;
		return true;
	}

	static class Pair {
		int y, x, cnt;
		int flag;

		Pair(int y, int x, int cnt,int flag) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.flag = flag;
		}
	}

}
