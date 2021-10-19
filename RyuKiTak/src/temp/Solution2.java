package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	static int N;
	static long answer;

	public static void main(String args[]) throws Exception {
		// 기본 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int Test = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Test; tc++) {

			N = Integer.parseInt(br.readLine());
			ArrayList<Integer> array = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				array.add(Integer.parseInt(st.nextToken()));
			}

			// 초기화
			answer = 0;

			// 연산
			subway(array, 0);

			// 정답 제출
			bw.append("#" + tc + " " + answer + "\n");
		}

		bw.flush();
		br.close();
		bw.close();

	}

	private static void subway(ArrayList<Integer> array, long now_tadang) {

		// 1. 인접 불가

		// 2. 인접 출발 / 도착 불가

		// 3. 같은역 출발/도착불가

		int length = array.size() - 2;
		for (int i = 0; i < array.size(); i++) {
			for (int j = i + 1; j < array.size(); j++) {
				if ((Math.abs(i - j) <= 1) || (Math.abs(i - j) == array.size() - 1))
					continue;
				// 배열을 둘로 나누기
				// 안쪽
				if (j - i >= 6) {
					ArrayList<Integer> subarray = new ArrayList<>();
					for (int k = i + 2; k <= j - 2; k++) {
						subarray.add(array.get(k));
					}
					subway2(subarray, tadangdo(array.get(i), array.get(j)));

				}
				// 바깥쪽if (j-i >= 6) {

				ArrayList<Integer> subarray2 = new ArrayList<>();
				for (int k = 0; k < i - 2; k++) {
					if (k > 0)
						subarray2.add(array.get(k));
				}
				for (int k = j + 2; k < array.size(); k++) {
					if (Math.abs(i - k) == array.size() - 1)
						continue;
					subarray2.add(array.get(k));
				}
				subway2(subarray2, tadangdo(array.get(i), array.get(j)));

			} // 배열종료

		}

		// 4. 만약 true 라면 최대 앤서 계산, 아니면 나눠서 재귀 돌리기

	}

	static void subway2(ArrayList<Integer> array, long now_tadang) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = i + 1; j < array.size(); j++) {
				if (Math.abs(i - j) <= 1)
					continue;
				answer = Math.max(answer, now_tadang + tadangdo(array.get(i), array.get(j)));
			}
		}
	}

	static long tadangdo(int a, int b) {
		return (a + b) * (a + b);

	}

}
