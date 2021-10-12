package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D14_섬의개수 {
	static int X, Y;
	static int[][] field;
	static boolean[][] visit;
	static int count;
	static int[] dx = { -1,-1,-1, 0,0,0, 1,1,1};
	static int[] dy = {  0,-1, 1,-1,0,1,-1,0,1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			if ( X==0 && Y==0 ) break;
			
			field = new int[X][Y];
			visit = new boolean[X][Y];
			count = 0;
			for (int i = 0; i < X; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < Y; j++) {
					int temp = Integer.parseInt(st.nextToken());
					field[i][j] = temp;
				}
			}
			
			// 1-땅 0-바다
			
			for (int i = 0; i < X; i++) {
				for (int j = 0; j < Y; j++) {
					if ( visit[i][j] == false && 
							field[i][j] == 1 ) {
						visit[i][j] = true;
						check(i,j);
						count +=1;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}
	
	static void check(int x, int y) {
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.add(new int[] {x,y});
		while( !Q.isEmpty() ) {
			int[] now = Q.poll();
			for (int i = 0; i < 9; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if ( nx<0 || ny<0 || nx>= X || ny >= Y  
					|| visit[nx][ny] == true || field[nx][ny] == 0 ) continue;
				
				visit[nx][ny] = true;
				Q.add(new int[] {nx,ny} );
				
			}
		}
	}
}
