package M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2206
public class D06_벽부수고이동하기_2트 {
	static int N,M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer = Integer.MAX_VALUE;
	static class player {
		int x;
		int y;
		int route;
		boolean punch;
		
		public player() {}
		public player(int x, int y, int route,boolean punch) {
			this.x = x;
			this.y = y;
			this.route = route;
			this.punch = punch;
		}
		
		@Override
		public String toString() {
			return "player [x=" + x + ", y=" + y + ", route=" + route + ", punch=" + punch + "]";
		}
		
		
	
	}
	static boolean[][][] visit;
	static int[] dx = { -1,0,1, 0};
	static int[] dy = {  0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];
		visit = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int temp = str.charAt(j) - '0';
				field[i][j] = temp;
			}
		}
		
		
		Queue<player> Q = new LinkedList<>();
		Q.add(new player(0,0,1,false));
		visit[0][0][0] = true;
		
		while(true) {
			if ( Q.isEmpty() ) break;
			
			player now = Q.poll();
			if ( now.route >= answer ) {
				continue;
			}
			if ( now.x == N-1 && now.y == M-1 ) {
				answer = now.route;
				continue;
			}
			System.out.println(now.toString());
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if( nx >= N || nx < 0 || ny>=M || ny<0) continue;
				
				if ( now.punch == false && field[nx][ny] == 1 && visit[nx][ny][1]==false ) {
					// 벽이고 아직 펀치 안했으면 뚫고 갈 수 있음.
					visit[nx][ny][1] = true;
					Q.add(new player(nx,ny,now.route+1,true));
				
				}
				
				// 아직 펀치 안햇고 벽안만남
				if ( now.punch == false && field[nx][ny] == 0 && visit[nx][ny][0]==false ) {
					visit[nx][ny][0] = true;
					Q.add(new player(nx, ny,  now.route+1, now.punch));
				}
				
				// 이미 펀치한번 날린상태 
				if ( now.punch == true && field[nx][ny] == 0 && visit[nx][ny][1]==false ) {
					visit[nx][ny][1] = true;
					Q.add(new player(nx, ny,  now.route+1, now.punch));
				}
				
				
			}
			
		}
		
		if (answer == Integer.MAX_VALUE) {
			bw.append(Integer.toString(-1));
		} else {
			bw.append(Integer.toString(answer));
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int k = 0; k < M; k++) {
//				if (visit[i][k] == Integer.MAX_VALUE ) {
//					System.out.print("X ");
//				} else {
//					System.out.print(visit[i][k] + " ");	
//				}
//			}
//			System.out.println();
//		}
//		
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}

}
