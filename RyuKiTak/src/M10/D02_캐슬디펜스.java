package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D02_캐슬디펜스 {
	static int N, M, D, maxkill;
	static int totalmonster;
	// 궁수리스트
	static int[] Archer = new int[3];
	
	static ArrayList<int[]> Alist = new ArrayList<>();
	static ArrayList<Monster> Mlist = new ArrayList<>();
	static ArrayList<Monster> nowMlist = new ArrayList<>();
	static class Monster {
		int x;
		int y;
		boolean live = true;
		
		public Monster(int x, int y) {
			this.x = x;
			this.y = y;
		}

		
		@Override
		public String toString() {
			return "Monster [x=" + x + ", y=" + y + ", live=" + live + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		// 적 입력받기
		totalmonster = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					// 적이면
					Mlist.add(new Monster(i,j));
					totalmonster += 1;
				}
			}
		}
		
		// 초기화
		// 답
		maxkill = 0;
		
		// 1. 궁수 조합 만들기
		setArcher(0,0);
		
		// 2. 각각 궁수 조합마다 몬스터 잡는 수 세기
		for (int[] link : Alist) {
			int temptotal = totalmonster;
			int killcount = 0;
			
			// 몬스터 초기화
			nowMlist.clear();
			for (int i = 0; i < temptotal; i++) {
				Monster T = new Monster(Mlist.get(i).x ,Mlist.get(i).y);
				nowMlist.add(T);
			}
			
			// 계산 시작
			while(true) {
				// 1. 궁수가 공격
				int[] attackindex = new int[3];
				for (int i = 0; i < 3; i++) {
					//지금궁수
					int Ax = N;
					int Ay = link[i];
					
					int index = 9999;
					int tempD = Integer.MAX_VALUE;
					for (int j = 0; j < nowMlist.size(); j++) {
						if ( !nowMlist.get(j).live) continue;
						// 거리계산
						int bx = nowMlist.get(j).x;
						int by = nowMlist.get(j).y;
						int dist = distance(Ax,Ay,bx,by);
						if ( dist <= D && dist <= tempD ) {
							// 가장 가까운 녀석 찾기
							if (tempD == dist) {
								// 만약 가까운녀석이 둘임
								// 지금 녀석이 더 왼쪽
								 
								if ( by < nowMlist.get(index).y) {
									// 이녀석이 더 왼쪽이면 
									index = j;
								}
							} else if ( dist < tempD) {
								// 가장 가까운녀석이다.
								tempD = dist;
								index = j;
							}
						}
					}
					
					attackindex[i] = index;
				}
				
				
				// 2. 궁수가 활을 쏜다.
				// 그래서 몹들이 죽는다.
				for (int i = 0; i < 3; i++) {
					if (attackindex[i] == 9999) continue;
					if(nowMlist.get(attackindex[i]).live) {
						nowMlist.get(attackindex[i]).live = false;
						killcount += 1;
						temptotal -= 1;
					}
				}
				
				// 2. 몬스터가 이동 
				for (int i = 0; i < nowMlist.size(); i++) {
					if ( !nowMlist.get(i).live ) continue;
					// 죽었으면 넘김
					nowMlist.get(i).x += 1; // 한칸 밑으로
					
					if (nowMlist.get(i).x == N ) {
						// 맨밑에왔다.
						nowMlist.get(i).live = false;
						temptotal -= 1;
					}
				}
				
				// 몬스터가 없으면 끝남 
				if (temptotal <= 0) break; 
			}
			
			// 검사하기
			maxkill = Math.max(killcount, maxkill);

		}
		System.out.println(maxkill);
		
	}
	
	// 궁수 조합 메소드
	static void setArcher(int index, int depth) {
//		System.out.println(depth);
		if ( depth == Archer.length) {
			// 인트에 넣기
//			System.out.println(Arrays.toString(Archer));
			int[] temp = new int[3];
			// 이걸그대로 해주어야한다.
			temp = Archer.clone();
			Alist.add(temp);
			return;
		}
		if (index == M) return;
		Archer[depth] = index;
		setArcher( index + 1, depth+1 );
		setArcher( index + 1, depth);
		
		
	}
	static int distance(int ax, int ay, int bx, int by) {
		return Math.abs(ax - bx) + Math.abs(ay - by);
	}
}
