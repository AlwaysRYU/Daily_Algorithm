package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636 {
	static int R, C, hour, cheese;
	static int[][] map;
	static boolean[][] visitAir;
	static boolean[][] visitCheese;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Node> qAir = new LinkedList<>();
	static Queue<Node> qCheese = new LinkedList<>();

	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visitAir = new boolean[R][C];
		visitCheese = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visitAir[0][0] = true;
		qAir.offer(new Node(0, 0));
		
		while (true) {
			// 공기 BFS 탐색하면서 공기와 접촉하는 (경계면) 치즈 찾기
			bfsAir();
			// 더 이상 치즈가 없으면 종료
			if (qCheese.isEmpty()) break;
			// 공기와 닿은 치즈를 모두 공기로 변경
			bfsCheese();
			
			hour++;
		}
		System.out.println(hour);
		System.out.println(cheese);
	}
	
	static void bfsAir() {
		while (!qAir.isEmpty()) {
			Node n = qAir.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = n.y + dr[i];
				int nc = n.x + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visitAir[nr][nc]) continue;
				
				if (map[nr][nc] == 0) {
					visitAir[nr][nc] = true;
					qAir.offer(new Node(nr, nc));
				} else if (map[nr][nc] == 1) {
					if (visitCheese[nr][nc]) continue; 
					visitCheese[nr][nc] = true;
					// 경게면에 있는 치즈 담기
					qCheese.offer(new Node(nr, nc));
				}
			}
		}
	}
	
	static void bfsCheese() {
		cheese = 0;
		while (!qCheese.isEmpty()) {
			Node n = qCheese.poll();
			map[n.y][n.x]= 0;
			visitAir[n.y][n.x]= true;
			qAir.offer(n);
			cheese++;
		}
	}
}
