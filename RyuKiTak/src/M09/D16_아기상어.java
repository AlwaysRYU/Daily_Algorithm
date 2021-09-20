package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class D16_아기상어 {
	static int N,M;
	static int[][] field;
	static int time;
	
	// 상어
	static int Sx, Sy, Ssize;
	
	
	static PriorityQueue<eatable_fish> PQ = new PriorityQueue<>();
	static class eatable_fish implements Comparable<eatable_fish> {
		int x;
		int y;
		int dist;
		
		public eatable_fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "eatable_fish [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(eatable_fish o) {
			// TODO Auto-generated method stub
			if (this.dist == o.dist) {
				return Integer.compare(this.x, o.x);
			} else {
				return Integer.compare(this.dist, o.dist);
			}
		}
		
		
	}
	

	// 물고기 먹는 메소드 
	static int Eat_fish() {
		
		// 1. 먹을수 있는 물고기를 검사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ( field[i][j] != 0 && field[i][j] < Ssize) {
					// 먹을 수 있는 물고기
					//
					for (int j2 = 0; j2 < N; j2++) {
						for (int k = 0; k < N; k++) {
							visit[j2][k] = false;
						}
					}
					// 최소 거리계산하기
					int distance = short_way(Sx,Sy,i,j);
//					System.out.println("현재 사이즈 : " + Ssize);
//					System.out.println("먹을 수 있는물고기찾음  : " + i + " - " + j + " " + distance);
					
					// 자동으로 정렬
					PQ.add(new eatable_fish(i, j, distance));
				}
			}
		}
		
		// 2. 제일앞에 있는 놈이 먹을 수 있는 놈임
		
		while(true) {
			if ( PQ.isEmpty() ) {
				break;
			}
			eatable_fish now = PQ.poll();
			if (now.dist == 0) continue;
			
			// 상어이동 시켜주기
			field[Sx][Sy] = 0; 
			Sx = now.x;
			Sy = now.y;
			field[now.x][now.y] = 9; // 상어으로바꿔주고
			
			PQ.clear(); // 이건 초기화 시켜줌
			return now.dist; // 걸린시간(거리)반환
			
		}
		return 0;
		
		
	}
	
	static boolean[][] visit;
	static int[] dx = { -1,1,0,0};
	static int[] dy = { 0,0,-1,1};
	static int short_way(int startX, int startY, int endX, int endY) {
		// 거리계산 시작
		
		int distance = 0;
		Queue<int[]> list = new LinkedList<>();
		
		list.add(new int[] {startX,startY,0});
		
		while(!list.isEmpty()) {
			int[] temp = list.poll();
			visit[temp[0]][temp[1]] = true;
			
			// 도착하면 끝
			if (temp[0] == endX && temp[1] == endY ) {
				// 도착
//				System.out.println("도착함 거리는 : " + temp[2]);
				distance = temp[2];
//				System.out.println(distance);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx<0 || ny <0 || nx >= N || ny >= N 
						|| field[nx][ny] > Ssize
						|| visit[nx][ny]) continue;
				
				list.add(new int[] {nx,ny, temp[2]+1 });
			}
		}
		
		
		return distance;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				
				if ( field[i][j] == 9 ) {
					Sx = i;
					Sy = j;
				}
			}
		}
		
		// 상어 설정
		Ssize = 2;
		
		
		time = 0;
		int eatcount = 0;
		// 먹을 수 있는 물고기를 찾기 
		while(true) {
			int eat_time = Eat_fish();
			if (eat_time == 0 ) {
//				System.out.println("못먹음");
				break; // 못먹음
			}
			// 먹은경우
			time += eat_time;
			eatcount += 1;
			if (eatcount == Ssize) {
				Ssize += 1;
				eatcount = 0;
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(field[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
		}
		
//		System.out.println();
//		System.out.println("답답");
		System.out.println(time);
		
	}

}
