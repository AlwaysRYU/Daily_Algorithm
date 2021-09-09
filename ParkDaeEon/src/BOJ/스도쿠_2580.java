package BOJ;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * DFS, Backtracking
 */
public class 스도쿠_2580 {
	static int map[][] = new int[9][9];
	static boolean row[][] = new boolean[9][10];
	static boolean col[][] = new boolean[9][10];
	static boolean square[][] = new boolean[9][10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int temp, squareIndex;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 행, 열, 정사각형 영역 안에 있는 숫자 체크
			for (int j = 0; j < 9; j++) {
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				squareIndex = 3 * (i / 3) + (j / 3);
				if (temp != 0) {
					row[i][temp] = true;
					col[j][temp] = true;
					square[squareIndex][temp] = true;
				}
			}
		}
		dfs(0);
	}
	
	private static void dfs(int n) throws Exception {
		if (n == 81) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			bw.write(sb.toString());
			bw.flush();

			System.exit(0);
		}
		int r = n / 9;
		int c = n % 9;
		if (map[r][c] == 0) {
			// 현재 자리에 1 ~ 9 시도
			for (int i = 1; i <= 9; i++) {
				int squareIndex = 3 * (r / 3) + (c / 3);
				if (!row[r][i] && !col[c][i] && !square[squareIndex][i]) {
					row[r][i] = true;
					col[c][i] = true;
					square[squareIndex][i] = true;
					map[r][c] = i;
					
					dfs(n + 1);
					
					row[r][i] = false;
					col[c][i] = false;
					square[squareIndex][i] = false;
					map[r][c] = 0;
				}
			}
		} else {
			dfs(n + 1);
		}
	}
}
