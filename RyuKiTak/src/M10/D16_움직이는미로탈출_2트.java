package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D16_움직이는미로탈출_2트 {
	static int[][] field = new int[8][8];
	static boolean find = false;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Node> Q = new LinkedList<>();
	static boolean[][] visit = new boolean[8][8];
	static int[] dx = {0,1,0,-1, 0 , 1, -1, 1, -1};
	static int[] dy = {1,0,-1,0, 0 , 1, -1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				char temp = str.charAt(j);
				if (temp == '#' ) {
					field[i][j] = 1;
				}
			}
		}
		
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print(field[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 연산
		Q.offer(new Node(7,0));
		while( !Q.isEmpty() ) {
			//방문초기화
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					visit[i][j] = false;
				}
			}
			int Qcount = Q.size();

//			System.out.println(Qcount);
			
			int temp = 0;
			while( temp < Qcount ) {
				Node now = Q.poll();
				temp += 1;
				
				if (field[now.x][now.y] == 1) {
					temp += 1;
					continue;
				}
				
				if (now.x == 0) {
					System.out.println(1);
					return;
				}
				for (int i = 0; i < 9; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if  (  nx<0 || ny <0 || nx>= 8 || ny >= 8  
							|| visit[nx][ny] || field[nx][ny] == 1 ) continue;
//					System.out.println(nx + " , " + ny + "로 이동");
					Q.add(new Node(nx,ny));
					visit[nx][ny] =true;
				}
				
				
			}
			
			// 벽이동
//			System.out.println("벽이동");
			for (int i = 7; i >= 1; i--) {
				for (int j = 0; j < 8; j++) {
					field[i][j] = field[i-1][j];
				}
			}
			
//			for (int i = 0; i < 8; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(field[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			
		}
		
		
		System.out.println(0);
		
	}
	
	
	

}
