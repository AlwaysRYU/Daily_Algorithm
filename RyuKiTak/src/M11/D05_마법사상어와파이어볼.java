package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/20056
public class D05_마법사상어와파이어볼 {
	static int N, M, K;
	static int[][][] field;
	
	static class FireBall {
		int x;
		int y;
		int m;
		int speed;
		int dir;
		
		public FireBall() {}
		public FireBall(int x, int y, int m, int speed, int dir) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.speed = speed;
			this.dir = dir;
		}
		
		@Override
		public String toString() {
			return "FireBall [x=" + x + ", y=" + y + ", m=" + m + ", speed=" + speed + ", dir=" + dir + "]";
		}
		
		
	}
	static ArrayList<FireBall> list = new ArrayList<>();
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {  0,  1, 1, 1, 0,-1, -1, -1};
	static class Node {
		int x;
		int y;
		int dir;
		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	static ArrayList<Node> Bunli = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		field = new int[N][N][2501];
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 파이어볼 M개
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x =  Integer.parseInt(st.nextToken()) -1;
			int y =  Integer.parseInt(st.nextToken()) -1;
			int m =  Integer.parseInt(st.nextToken());
			int s =  Integer.parseInt(st.nextToken());
			int d =  Integer.parseInt(st.nextToken());
			field[x][y][2500] += 1;
			field[x][y][i] += 1;
			list.add(new FireBall(x,y,m,s,d));
		}
		
		// 이동
		for (int i = 0; i < K; i++) {
			System.out.println((i+1) + " 번째 움직임..");
			ArrayList<Integer> indexlist = new ArrayList<>();
			
			Bunli.clear();
			// 1. 모든 파이어볼 이동
			for (int j = 0; j < list.size(); j++) {
				FireBall now = list.get(j);
				//System.out.println(now.toString());
				field[now.x][now.y][2500] -= 1;
				field[now.x][now.y][j] -= 1;
				
				// 이동 
				for (int k = 0; k < now.speed; k++) {
					now.x += dx[now.dir];
					if ( now.x == N ) {
						now.x = 0;
					} else if ( now.x < 0 ) {
						now.x = N-1;
					}
					
					now.y += dy[now.dir];
					if ( now.y == N ) {
						now.y = 0;
					} else if ( now.y < 0 ) {
						now.y = N-1;
					}
				}// 개별 이동완료

				System.out.println(now.toString() + "<-- 이동완료 " );
				field[now.x][now.y][2500] += 1;
				field[now.x][now.y][j] += 1;
				if ( field[now.x][now.y][2500] >=2 ) {
					// 겹치면
					System.out.println(now.x + "/" + now.y + " 가 겹친다.  --> " + j);
					Bunli.add(new Node(now.x, now.y, now.dir));
				}
				
			}
			
			System.out.println("파이이어볼 개수 " + list.size() );
			// 2. 이동 끝나고 체크하기
			for (int j = 0; j < Bunli.size(); j++) {
				System.out.println(Bunli.get(j).x + "/" + Bunli.get(j).y + " 가 겹친다.  --> " + j);
				int hapM = 0;
				int hapS = 0;
				int hapcount = 0;
				boolean sameDir = true;
				for (int j2 = 2499; j2 >= 0 ; j2-- ) {
					
					// 0 이상이면 여기 위치에 있는거임
					if ( field[Bunli.get(j).x][Bunli.get(j).y][j2] > 0 ) {
						System.out.println("리스트 인덱스 : " + j2);
						hapcount += 1;
						FireBall FB = list.get(j2);
						hapM += FB.m;
						hapS += FB.speed;
						list.get(j2).m = 0;
						
						// list.remove(j2);
						
						// 방향이 다르면
						if (sameDir && Bunli.get(j).dir % 2 != FB.dir %2) {
							sameDir = false;
						}
						
						
					}
				}
				
				
				// 전부 확인 완료
				// 합이 5이상일경우만
				if ( hapM >= 5 ) {
					if ( sameDir ) {
						// 전부 같은 방향이면
						// 0 2 4 6
						for (int k = 0; k <= 6 ; k += 2) {
							list.add( new FireBall( Bunli.get(j).x, Bunli.get(j).y, hapM/5, hapS/hapcount ,k));
						}
					} else {
						// 1 3 5 7
						for (int k = 1; k <= 7 ; k += 2) {
							list.add( new FireBall( Bunli.get(j).x, Bunli.get(j).y, hapM/5, hapS/hapcount ,k));
						}
					}
				}
				
				
				//
				
			}
			// 0인거 제거
			for (int jj = list.size() -1; jj >= 0; jj--) {
				if ( list.get(jj).m == 0) list.remove(jj);
			}
			
		}// ㅇ이동 끝
		// 남아있는 파이어볼 질량의 합 구하기
		
		
		System.out.println("이동종료-----------------------");
		System.out.println("파이이어볼 개수 " + list.size() );
		int answer = 0;
		for(FireBall x : list ) {
			answer += x.m;
		}
		System.out.println(answer);
		
	}

}
