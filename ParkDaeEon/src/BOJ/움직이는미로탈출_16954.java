package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 움직이는미로탈출_16954 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer[]> q = new LinkedList<>();
		int ans = 0;
		char[][] arr = new char[8][];
		boolean[][] visit = new boolean[8][8];
		
		for (int i = 0; i < 8; i++)
			arr[i] = br.readLine().toCharArray();
		
		q.offer(new Integer[] { 7, 0, 0 });
		visit[7][0] = true;

		int cSec = 0;
		while (!q.isEmpty()) {
			int cr = q.peek()[0];
			int cc = q.peek()[1];
			int sec = q.poll()[2];
			
			if (sec != cSec) {
				down(arr);
				cSec = sec;
				for (int i = 0; i < 8; i++)
					for (int j = 0; j < 8; j++)
						visit[i][j] = false;
			}
			
			if (arr[cr][cc] == '#') continue;
			
			if (cr == 0 && cc == 7) {
				ans = 1;
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				int nsec = sec + 1;
				
				if (nr < 0 || nc >= 8 || nr >= 8 || nc < 0 || visit[nr][nc] || arr[nr][nc] == '#') continue;
				q.offer(new Integer[] { nr, nc, nsec });
				visit[nr][nc] = true;
			}
		}
		
		System.out.println(ans);
	}

	static void down(char[][] map) {
		for (int i = 7; i >= 1; i--)
			map[i] = map[i - 1];
		
		map[0] = new char[] {'.', '.', '.', '.', '.', '.', '.', '.'};
	}
}
