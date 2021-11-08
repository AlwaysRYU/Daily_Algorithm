package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준17143낚시왕 {

	static int N;
	static int M;
	static Shark[][] map;
	static Shark[][] map2;
	static int result;
	static int S;
	

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		map = new Shark[N + 2][M + 2];
		map2 = new Shark[N + 2][M + 2];

		init();
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(bf.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[y][x] = new Shark(speed, dir, size);
		}
		for (int i = 1; i < M + 2; i++) {
			fishing(i);
			move();
			
			clonMap();
		}

		System.out.println(result);

	}

	

	



	private static void move() throws Exception {
		// TODO Auto-generated method stub

		int dpY[] = { -1, 1, 0, 0 };
		int dpX[] = { 0, 0, 1, -1 };
		// 위 아래 오른쪽 왼쪽
		for (int i = 1; i < N+2; i++) {
			for (int j = 1; j <M+2; j++) {
				if (map[i][j].size != 0) {

					int dir = map[i][j].dir;
					int speed = map[i][j].speed;
					int ny = 0;
					int nx = 0;
					switch (map[i][j].dir) {
					case 1: // 상
						if (i-1 >= speed) {
							ny = i - speed;
							nx = j;
						} else {
							nx = j;
							int temp = (speed - (i - 1));
							if ((temp / (N - 1)) % 2 == 0) {
								ny = temp % (N - 1) + 1;
								map[i][j].dir =2;
							}
							else
								ny = N - temp % (N - 1);
						}
						break;///////
					case 2:// 하
						if (N - i >= speed) {
							ny = i + speed;
							nx = j;
						} else {

							nx = j;
							int temp = (speed - (N - i));
							if ((temp / (N - 1)) % 2 != 0) {
								ny = temp % (N - 1) + 1;
								

							}
							else {
								ny = N - temp % (N - 1);
								map[i][j].dir =1;
							}
						}
						break;
					case 3:// 우
						if (M - j >= speed) {
							nx = j + speed;
							ny = i;
						} else {

							ny = i;
							int temp = (speed - (M - j));
							if ((temp / (M - 1)) % 2 != 0)
								nx = temp % (M - 1) + 1;
							else {
								nx = M - temp % (M - 1);
								map[i][j].dir =4;
							}
						}
						break;
					case 4:// 좌
						if (j-1 >= speed) {
							nx = j - speed;
							ny = i;
						} else {
							ny = i;
							int temp = (speed - (j - 1));
							if ((temp / (M - 1)) % 2 == 0) {
								nx = temp % (M - 1) + 1;
								map[i][j].dir =3;
							}
							else
								nx = M - temp % (M - 1);
						}
						break;///////

					}
					
					
					if(map2[ny][nx].size < map[i][j].size)
					{
						map2[ny][nx] = (Shark) map[i][j].clone();
					}
				}
			}
		}
	}

	private static void fishing(int where) {

		int sharkLoc = 0;
		for (int i = 1; i < N + 2; i++) {

			if (map[i][where].size != 0) {
				result += map[i][where].size;
				map[i][where].size = 0;
				map[i][where].dir = 0;
				map[i][where].speed = 0;
				return;
			}

		}

	}

	private static void init() {

		for (int i = 1; i < N + 2; i++) {
			for (int j = 1; j < M + 2; j++) {
				map[i][j] = new Shark(0, 0, 0);
				map2[i][j] = new Shark(0, 0, 0);
			}
		}

	}
	private static void clonMap() {
		for (int i = 1; i < N + 2; i++) {
			for (int j = 1; j < M + 2; j++) {
				map[i][j] = map2[i][j];
				map2[i][j] = new Shark(0, 0, 0);
			}
		}
		
	}

	private static class Shark implements Cloneable {

		int speed;
		int dir;
		int size;

		public Shark(int speed, int dir, int size) {
			super();
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
}
