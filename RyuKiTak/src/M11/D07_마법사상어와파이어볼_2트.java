package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/20056
public class D07_마법사상어와파이어볼_2트 {
	static int N, M, K;

	static List<FireBall>[][] field;
	static List<FireBall>[][] aftermove;
	static class FireBall {
		int mass;
		int speed;
		int dir;
		
		public FireBall() {}
		public FireBall(int m, int speed, int dir) {
			this.mass = m;
			this.speed = speed;
			this.dir = dir;
		}
		
		@Override
		public String toString() {
			return "FireBall [mass=" + mass + ", speed=" + speed + ", dir=" + dir + "]";
		}
		
	}
	
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {  0,  1, 1, 1, 0,-1, -1, -1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		field = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				field[i][j] = new ArrayList<>();
			}
		}
		
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
			field[x][y].add(new FireBall(m,s,d));
		}
		
		// 이동
		for (int ttt = 0; ttt < K; ttt++) {
			System.out.println((ttt+1) + " 번째 움직임..");

			aftermove = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					aftermove[i][j] = new ArrayList<>();
				}
			}
			// 1. 모든 파이어볼 이동
			for (int xxx = 0; xxx < N; xxx++) {
				for (int yyy = 0; yyy < N; yyy++) {
					// 파이어볼이 있으면 이동
					if ( field[xxx][yyy].size() >= 1) {
						
						for(FireBall now : field[xxx][yyy]) {
							// 이동 
							int nx = xxx;
							int ny = yyy;
							for (int k = 0; k < now.speed; k++) {
								nx += dx[now.dir];
								if ( nx == N ) {
									nx = 0;
								} else if ( nx < 0 ) {
									nx = N-1;
								}
								
								ny += dy[now.dir];
								if ( ny == N ) {
									ny = 0;
								} else if ( ny < 0 ) {
									ny = N-1;
								}
							}// 개별 이동완료
							
							aftermove[nx][ny].add(new FireBall(now.mass, now.speed, now.dir));
						}
						
					}
				}
			} // 전부 체크 완료
			
			// 붙여넣기
			field = aftermove.clone();
			
			// 2. 분리 시작
			for (int xxx = 0; xxx < N; xxx++) {
				for (int yyy = 0; yyy < N; yyy++) {
					// 2이상이면 분리 하기
					if ( field[xxx][yyy].size() >= 2) {
						int hapM = 0;
						int hapS = 0;
						boolean allJJack = true;
						boolean allHoll = true;
						for (int j = 0; j < field[xxx][yyy].size(); j++) {
							hapM += field[xxx][yyy].get(j).mass;
							hapS += field[xxx][yyy].get(j).speed;
							if (field[xxx][yyy].get(j).dir % 2 == 0 ) allHoll = false;
							else allJJack = false;
							
						}
						
						hapS /= field[xxx][yyy].size();
						field[xxx][yyy].clear();
						
						// hapM이 5이상만
						if (hapM >= 5) {
							if ( allJJack == true || allHoll == true) {
								// 0 2 4 6
								for (int k = 0; k <= 6 ; k += 2) {
									field[xxx][yyy].add( new FireBall(  hapM/5, hapS ,k));
								}
							} else {
								// 1 3 5 7
								for (int k = 1; k <= 7 ; k += 2) {
									field[xxx][yyy].add( new FireBall( hapM/5, hapS,k));
								}
							}
						}
						
						
						
						
					}
				}
			} // 전부 체크 완료
			
		}
		
		System.out.println("이동종료-----------------------");
		int answer = 0;
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < N; j2++) {
				if ( field[j][j2].size() > 0 ) {
					for (int k = 0; k < field[j][j2].size(); k++) {
						answer += field[j][j2].get(k).mass;
					}
				}
			}
		}
		System.out.println(answer);
		
	}
	}


