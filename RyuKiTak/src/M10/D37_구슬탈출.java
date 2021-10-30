package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D37_구슬탈출 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] first;
	static int N, M;

	static class Node {
		int x;
		int y;

		public Node() {
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}

	static Node Red = new Node();
	static Node Blue = new Node();
	static int answer = 0;
	// -1은 답이없음 0은 실패 1은성공

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		first = new char[N][M];
		// 맵입력받기
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				first[i][j] = temp.charAt(j);
				if (first[i][j] == 'B') {
					Blue.x = i;
					Blue.y = j;
				} else if (first[i][j] == 'R') {
					Red.x = i;
					Red.y = j;
				}
			}
		}

		// 맵출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(first[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		play(0, Red, Blue);
		
		System.out.println(answer);
	}

	static int N_RedX;
	static int N_RedY;
	static int N_BlueX;
	static int N_BlueY;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static void play(int depth, Node Red, Node Blue) {
		if (answer == 1)
			return;
		if (depth == 10) {
			return;
		}
		
		System.out.println("현재 기울인 횟수 " + depth);
		System.out.println("현재 빨간공 위치 : " + Red.x + " " + Red.y);
		System.out.println("현재 파란공 위치 : " + Blue.x + " " + Blue.y);
		N_RedX = Red.x;
		N_RedY = Red.y;
		N_BlueX = Blue.x;
		N_BlueY = Blue.y;
		// 만나는동안 탈출하면 종료
		// 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 반드시 두개 다 확인하기.
		// 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다.
		// 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
		// 기울이는거 끝나면

		int resultR, resultB;
		// 위 0
		// 빨강 파랑 중 위에 있는것부터 먼저 움직인다.
		System.out.println("위로 이동");
		if (Red.y < Blue.y) {
			// 빨강이 위에 있음
			// 0은 벽을 만남 1은 탈출함
			resultR = moveBall(N_RedX, N_RedY, 0, true);
			resultB = moveBall(N_BlueX, N_BlueY, 0, false);
		} else {
			// 파랑볼을 먼저 움직임
			resultB = moveBall(N_BlueX, N_BlueY, 0, false);
			resultR = moveBall(N_RedX, N_RedY, 0, true);
		}
		// 결과에 따라
		if (resultR == 1 && resultB== 0) {
			// 둘중하나가 1인 경우만
			answer = 1;
			return;
		} else if (resultR + resultB == 0) {
			// 둘다 0 이면 다음 계산을 할수 있음
			play(depth + 1, new Node(N_RedX, N_RedY), new Node(N_BlueX, N_BlueY));
		}
		// 둘다 1인 경우는 그냥 넘김
		if (answer == 1)
			return;
		// 우 1 ------ //
		// 초기화
		N_RedX = Red.x;
		N_RedY = Red.y;
		N_BlueX = Blue.x;
		N_BlueY = Blue.y;
		System.out.println("우측로 이동");
		if (Red.x < Blue.x) {
			// 파랑이 우측에 있음
			// 파랑을 먼저 움직임
			resultB = moveBall(N_BlueX, N_BlueY, 1, false);
			resultR = moveBall(N_RedX, N_RedY, 1, true);
		} else {
			// 파랑볼을 먼저 움직임
			resultR = moveBall(N_RedX, N_RedY, 1, true);
			resultB = moveBall(N_BlueX, N_BlueY, 1, false);
		}
		// 결과에 따라
		if (resultR == 1 && resultB== 0) {
			// 둘중하나가 1인 경우만
			System.out.println("성공!");
			answer = 1;
			return;
		} else if (resultR + resultB == 0) {
			// 둘다 0 이면 다음 계산을 할수 있음
			play(depth + 1, new Node(N_RedX, N_RedY), new Node(N_BlueX, N_BlueY));
		}
		if (answer == 1)
			return;
		// 밑 2
		// 초기화
		N_RedX = Red.x;
		N_RedY = Red.y;
		N_BlueX = Blue.x;
		N_BlueY = Blue.y;
		System.out.println("밑으로 이동");
		if (Red.y < Blue.y) {
			// 빨강이 위에 있으므로 파랑을 먼저 움직임
			resultB = moveBall(N_BlueX, N_BlueY, 0, false);
			resultR = moveBall(N_RedX, N_RedY, 0, true);
		} else {
			// 파랑볼을 먼저 움직임
			resultR = moveBall(N_RedX, N_RedY, 0, true);
			resultB = moveBall(N_BlueX, N_BlueY, 0, false);
		}
		// 결과에 따라
		if (resultR == 1 && resultB== 0) {
			// 둘중하나가 1인 경우만
			answer = 1;
			return;
		} else if (resultR + resultB == 0) {
			// 둘다 0 이면 다음 계산을 할수 있음
			play(depth + 1, new Node(N_RedX, N_RedY), new Node(N_BlueX, N_BlueY));
		}
		if (answer == 1)
			return;
		// 좌 3
		System.out.println("좌로 이동");
		if (Red.x < Blue.x) {
			// 빨강이 왼쪽에 있음
			resultR = moveBall(N_RedX, N_RedY, 1, true);
			resultB = moveBall(N_BlueX, N_BlueY, 1, false);
		} else {
			// 파랑볼을 먼저 움직임
			resultB = moveBall(N_BlueX, N_BlueY, 1, false);
			resultR = moveBall(N_RedX, N_RedY, 1, true);
		}
		// 결과에 따라
		if (resultR == 1 && resultB== 0) {
			// 둘중하나가 1인 경우만
			answer = 1;
			return;
		} else if (resultR + resultB == 0) {
			// 둘다 0 이면 다음 계산을 할수 있음
			play(depth + 1, new Node(N_RedX, N_RedY), new Node(N_BlueX, N_BlueY));
		}
		if (answer == 1)
			return;
	}

	// 0은 벽을 만남 1은 탈출함
	private static int moveBall(int X, int Y, int i, boolean red) {
		// TODO Auto-generated method stub
		int nx = X;
		int ny = Y;
		while (true) {
			nx += dx[i];
			ny += dy[i];

			if (first[nx][ny] == '#') {
				// 벽을 만남
				// 위치 바꿔주고
				if (red) {
					N_RedX = nx - dx[i];
					N_RedY = ny - dy[i];
				} else {
					N_BlueX = nx - dx[i];
					N_BlueY = ny - dy[i];
				}
				return 0;
			} else if (red && nx == N_BlueX && ny == N_BlueY) {
				N_RedX = nx - dx[i];
				N_RedY = ny - dy[i];
				return 0;
			} else if (!red && nx == N_RedX && ny == N_RedY) {
				N_BlueX = nx - dx[i];
				N_BlueY = ny - dy[i];
				return 0;
			} else if (first[nx][ny] == 'O') {
				return 1;
			}

		}
	}

}
