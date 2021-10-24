package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class EASY2048_12100 {
	static int N, max;
	static int[][] startPos;
	static int[] d = {2, 2, 0, 0};
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		startPos = new int[][] {
			{0, 0},			// 상
			{N - 1, 0},		// 하
			{0, 0},			// 좌
			{0, N - 1}		// 우
		};
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0, board);

		System.out.println(max);
	}
	
	static void perm(int tgtIdx, int[][] board) {
		if (tgtIdx == 5) return;

		int[][] curBoard;

		for (int i = 0; i < 4; i++) {
			curBoard = copyBoard(board);

			detect(i, curBoard);
			merge(i, curBoard);
			
			perm(tgtIdx + 1, curBoard);
		}
	}
	
	static int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				newBoard[i][j] = board[i][j];
		return newBoard;
	}

	static void merge(int dir, int[][] board) {
		int sr = startPos[dir][0];
		int sc = startPos[dir][1];
		
		int nr = sr;
		int nc = sc;
		
		for (int rc = 0; rc < N; rc++) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int n = board[nr][nc];
				
				if (n != 0) list.add(n);
				max = Math.max(max, n);
				nr += dr[dir];
				nc += dc[dir];
			}
			
			nr = sr;
			nc = sc;
			
			int j = 0;
			while (j < list.size()) {
				board[nr][nc] = list.get(j);
				j++;
				nr += dr[dir];
				nc += dc[dir];
			}
			while (j < N) {
				board[nr][nc] = 0;
				j++;
				nr += dr[dir];
				nc += dc[dir];
			}
			
			sr += dr[d[dir]];
			sc += dc[d[dir]];
			nr = sr;
			nc = sc;
		}
	}

	static void detect(int dir, int[][] board) {
		Stack<Integer[]> st = new Stack<>();
		int sr = startPos[dir][0];
		int sc = startPos[dir][1];
		
		int nr = sr;
		int nc = sc;
		
		for (int rc = 0; rc < N; rc++) {
			st.clear();
			for (int i = 0; i < N; i++) {
				int n = board[nr][nc];
				
				if (n != 0) {
					// 스택이 비어 있으면 넣기
					if (st.isEmpty() || st.peek()[0] != n) st.push(new Integer[] {n, nr, nc});
					// 스택에 같은 숫자가 들어있으면 숫자 합치기
					else if (st.peek()[0] == n) {
						// 숫자 합치기
						int mr = st.peek()[1];
						int mc = st.pop()[2];
						merge(mr, mc, nr, nc, board);
						st.clear();
					}
				}
				nr += dr[dir];
				nc += dc[dir];
			}
			sr += dr[d[dir]];
			sc += dc[d[dir]];
			nr = sr;
			nc = sc;
		}
	}

	static void merge(int mr, int mc, int nr, int nc, int[][] board) {
		board[mr][mc] *= 2;
		board[nr][nc] = 0;
	}
}
