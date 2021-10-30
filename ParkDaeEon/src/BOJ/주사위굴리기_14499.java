package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {
	
	static int[] dice = new int[7];
	static int[] ndice = new int[7];
	static int[][] map;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int R, C, x, y, K;
	
	static int diceFloorNum = 6;
	static int getDiceFloorNumNext(int dir) {
		for (int i = 1; i <= 6; i++) dice[i] = ndice[i];
		switch (dir) {
		case 1:	// 동
			ndice[4] = dice[6];
			ndice[1] = dice[4];
			ndice[3] = dice[1];
			ndice[6] = dice[3];
			break;
		case 2:	// 서
			ndice[4] = dice[1];
			ndice[1] = dice[3];
			ndice[3] = dice[6];
			ndice[6] = dice[4];
			break;
		case 3:	// 북
			ndice[2] = dice[6];
			ndice[1] = dice[2];
			ndice[5] = dice[1];
			ndice[6] = dice[5];
			break;
		case 4:	// 남
			ndice[2] = dice[1];
			ndice[1] = dice[5];
			ndice[5] = dice[6];
			ndice[6] = dice[2];
			break;
		}
		return ndice[6];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int d;
		int cr = x;
		int cc = y;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			d = Integer.parseInt(st.nextToken());
			
			cr += dr[d];
			cc += dc[d];
			
			if (cr < 0 || cc < 0 || cr >= R || cc >= C) {
				cr -= dr[d];
				cc -= dc[d];
				continue;
			}
			
			if (map[cr][cc] == 0) {
				map[cr][cc] = getDiceFloorNumNext(d);
			} else {
				getDiceFloorNumNext(d);
				ndice[6] = map[cr][cc];
				map[cr][cc] = 0;
			}
			System.out.println(ndice[1]);
		}
	}
}
