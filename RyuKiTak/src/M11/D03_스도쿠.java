package M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class D03_스도쿠 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int zerocount = 0;
	static int[][] field = new int[9][9];
	static boolean find = false;
	static class Node {
		int x;
		int y;
		
		public Node() {}
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static ArrayList<Node> zerolist = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				// 0 일경우 필드에 넣어준다.
				if (field[i][j] == 0) {
					zerolist.add(new Node(i,j));
					zerocount += 1;
				}
			}
		}
		
		sudoku(0);
		
	}


	private static void sudoku(int listindex) throws Exception {
		if (find) return;
		if (listindex >= zerocount ) {
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					bw.append(Integer.toString(field[i][j]) + " ");
				}
				bw.append("\n");
			}
			find = true;
			bw.flush();
			return;
		}
		
		// 지금
		int nowX = zerolist.get(listindex).x;
		int nowY = zerolist.get(listindex).y;
		for (int number = 1; number <= 9; number++) {
			// 1 부터 체크한다.
			// 찾으면 트루
			boolean FIND = false;
			
			// 가로
			for (int i = 0; i < 9; i++) {
				if ( field[nowX][i] == number ) {
					FIND = true;
					break;
				}
			}
			if (FIND) continue;
			
			// 세로
			for (int i = 0; i < 9; i++) {
				if ( field[i][nowY] == number ) {
					FIND = true;
					break;
				}
			}
			if (FIND) continue;
			
			// 정사각형 안에 없는 수만 가능하다.
			int mX = (nowX / 3) * 3;
			int mY = (nowY / 3) * 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if ( field[mX+i][mY+j] == number ) {
						FIND = true;
						break;
					}
				}
				if (FIND) break;
			}
			
			if (FIND) continue;
			
			// 해당수를 장착하고 재귀돌리기
			
			field[nowX][nowY] = number;
			sudoku(listindex+1);
			field[nowX][nowY] = 0;	
			
		}
		
	}

}
