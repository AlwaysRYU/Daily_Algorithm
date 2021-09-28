package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준키순서2458 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = 100 * 100;
	static int n, m;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];

		// 입력받은 값으로 변수 초기화
		init();
		// 플로이드 와샬 알고리즘
		floydWarshall();

		int count = 0;
		// 출력을 위한 객체
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == INF)
					System.out.print(0 + " ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == INF) {
					if (i != j && arr[j][i] == INF) {
						count--;
						break;
					}
				}
			}
			count++;
		}
		System.out.println(count);
	}

	private static void init() throws IOException {
		for (int i = 0; i <= n; i++)
			Arrays.fill(arr[i], INF);

		// 자기 자신으로 가는 경로 0으로 초기화
		for (int i = 1; i <= n; i++)
			arr[i][i] = 0;

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 기존의 값보다 작은 값이 들어오면 갱신해준다.
			arr[start][end] = 1;
		}
	}

	private static void floydWarshall() {
		// 경유 노드
		for (int i = 1; i <= n; i++) {
			// 시작 노드
			for (int j = 1; j <= n; j++) {
				// 시작 노드 != 경유 노드
				if (i != j) {
					// 도착 노드
					for (int k = 1; k <= n; k++) {
						// 시작노드 != 도착노드 && 도착노드 != 경유노드
						if (j != k && i != k) {
							// 기존의 값 보다 경유한 값이 작은 경우
							if (arr[j][k] > arr[j][i] + arr[i][k]) {
								arr[j][k] = arr[j][i] + arr[i][k];
							}
						}
					}
				}
			}
		}
	}
}