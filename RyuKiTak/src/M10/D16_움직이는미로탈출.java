package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D16_움직이는미로탈출 {
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
	static ArrayList<Node> wall = new ArrayList<>();
	static boolean[][] visit = new boolean[8][8];
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				char temp = str.charAt(j);
				if (temp == '#' ) {
					wall.add(new Node(i,j));
				}
			}
		}
		
		visit[7][0] = true;
		search(7,0,0);
		
		if (find) System.out.println(1);
		else System.out.println(0);
		
	}
	
	static int distance(int x, int y, int a, int b) {
		return Math.abs(x-a) + Math.abs(y-b);
	}
	static int[] dx = {0,1,0,-1,0 , 1, -1, 1, -1};
	static int[] dy = {1,0,-1,0,0 , 1, -1, -1, 1};
	static void search(int x, int y, int time) {
		if (find) return;
		if ( x == 0 && y == 7 ) {
			find = true;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if  (  nx<0 || ny <0 || nx>= 8 || ny >= 8  || visit[nx][ny]
					)continue;
			// 일단범위 내
			boolean walltouch = false;
			for ( Node NN : wall) {
				if ( distance(NN.x, NN.y, x, y) >= 3 ) continue;
				if ( NN.x+time == nx && NN.y == ny )  {
//					System.out.println("벽에 닿임");
					walltouch = true;
					break;
				}
				for ( Node now : wall ) {
					
					int wallX = now.x + (time+1);
					if (wallX >= 8 ) continue;
					int wallY = now.y;
					if ( distance(wallX, wallY, x, y) >= 3 ) continue;
					if (( wallX == nx && wallY == ny )) {
//						System.out.println("벽에 닿임");
						walltouch = true;
						break;
					}
					
				}
				
			}
			
			if (walltouch) continue;
			visit[nx][ny] = true;
			search(nx,ny,time+1);
			visit[nx][ny] = false;
		}
		
	}
	

}
