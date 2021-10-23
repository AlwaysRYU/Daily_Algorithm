package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import M10.D31_2048_테스트용.Node;

//https://www.acmicpc.net/problem/12100
public class D31_2048 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, answer;
	static int[] direction = new int[5];

	static int[][] fieldC;
	static int[][] field;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;

		play2048(0);

		System.out.println(answer);

	}

	private static void play2048(int depth) {
		// TODO Auto-generated method stub

		if (depth == 5) {
//			answer 계산
			System.out.println(Arrays.toString(direction));

			// 방향대로 계산
			fieldC = field.clone();
			for (int i = 0; i < 5; i++) {
				go_block(direction[i]);
			}
			return;
		}

		//
		// 4방향돌리기
		for (int i = 0; i < 4; i++) {
			direction[depth] = i;
			play2048(depth + 1);
		}

	}

	// 위 우 밑 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node {
		int number;
		boolean change;

		public Node() {
		}

		public Node(int number, boolean change) {
			this.number = number;
			this.change = change;
		}
	}

	private static void go_block(int dir) {
		// 초기화
		int listindex = 0;
		ArrayList<Node> list = new ArrayList<>();

		if (dir == 0) {
			// 위로 옮기기
			System.out.println("위로 옮길 것");
			for (int i = 0; i < N; i++) {
				listindex = 0;
				list.clear();
				for (int j = 0; j < N; j++) {
					if (fieldC[j][i] != 0) {
						if (list.size() == 0) {
							// 리스트에 숫자가 한개도 없으면
							list.add(new Node(fieldC[j][i], false));
							listindex += 1;
						} else {
							// 리스트에 숫자가 있으면
							if (list.get(listindex - 1).number == fieldC[j][i]
									&& list.get(listindex - 1).change == false) {
								// 이전숫자가 지금 숫자랑 같고
								// 변화한적이 없다면,
								list.get(listindex - 1).number *= 2;
								list.get(listindex - 1).change = true;
							} else {
								// 아니면 그냥 리스트에 넣어줌
								list.add(new Node(fieldC[j][i], false));
								listindex += 1;
							}
						}
					}
				}
				// 리스트에서 배열로 옮겨주기
				for (Node X : list) {
					System.out.print(X.number + " ");
				}
				System.out.println();

				int max = list.size();
				for (int j = 0; j < N; j++) {
					if (j >= max) {
						fieldC[j][i] = 0;
					} else {
						fieldC[j][i] = list.get(j).number;
					}
				}
			}

		} else if (dir == 1) {
			// 우측으로 옮기기
			System.out.println(" 우측으로 옮길 것");
			for (int j = 0; j < N; j++) {
				listindex = 0;
				list.clear();
				for (int i = 0; i < N; i++) {
					if (fieldC[j][i] != 0) {
						if (list.size() == 0) {
							// 리스트에 숫자가 한개도 없으면
							list.add(new Node(fieldC[j][i], false));
							listindex += 1;
						} else {
							// 리스트에 숫자가 있으면
							if (list.get(listindex - 1).number == fieldC[j][i]
									&& list.get(listindex - 1).change == false) {
								// 이전숫자가 지금 숫자랑 같고
								// 변화한적이 없다면,
								list.get(listindex - 1).number *= 2;
								list.get(listindex - 1).change = true;
							} else {
								// 아니면 그냥 리스트에 넣어줌
								list.add(new Node(fieldC[j][i], false));
								listindex += 1;
							}
						}
					}
				}
				// 리스트에서 배열로 옮겨주기
				for (Node X : list) {
					System.out.print(X.number + " ");
				}
				System.out.println();

				int temp = N - list.size();
				int index = 0;
				for (int i = 0; i < N; i++) {
					if (i >= temp) {
						fieldC[j][i] = list.get(index).number;
						index += 1;
					} else
						fieldC[j][i] = 0;
				}

			}

		} else if (dir == 2) {
			// 밑으로 옮기기
			System.out.println(" 밑으로 옮길 것 ");
			for (int i = 0; i < N; i++) {
				listindex = 0;
				list.clear();
				for (int j = 0; j < N; j++) {
					if (fieldC[j][i] != 0) {
						if (list.size() == 0) {
							// 리스트에 숫자가 한개도 없으면
							list.add(new Node(fieldC[j][i], false));
							listindex += 1;
						} else {
							// 리스트에 숫자가 있으면
							if (list.get(listindex - 1).number == fieldC[j][i]
									&& list.get(listindex - 1).change == false) {
								// 이전숫자가 지금 숫자랑 같고
								// 변화한적이 없다면,
								list.get(listindex - 1).number *= 2;
								list.get(listindex - 1).change = true;
							} else {
								// 아니면 그냥 리스트에 넣어줌
								list.add(new Node(fieldC[j][i], false));
								listindex += 1;
							}
						}
					}
				}
				// 리스트에서 배열로 옮겨주기
				for (Node X : list) {
					System.out.print(X.number + " ");
				}
				System.out.println();

				int temp = N - list.size();
				int index = 0;
				for (int j = 0; j < N; j++) {
					if (j >= temp) {
						fieldC[j][i] = list.get(index).number;
						index += 1;
					} else
						fieldC[j][i] = 0;
				}
			}

		} else {
			// 왼쪽으로 옮기기
			System.out.println(" 왼쪽으로 옮길 것 ");
			for (int j = 0; j < N; j++) {
				listindex = 0;
				list.clear();
				for (int i = 0; i < N; i++) {
					if (fieldC[j][i] != 0) {
						if (list.size() == 0) {
							// 리스트에 숫자가 한개도 없으면
							list.add(new Node(fieldC[j][i], false));
							listindex += 1;
						} else {
							// 리스트에 숫자가 있으면
							if (list.get(listindex - 1).number == fieldC[j][i]
									&& list.get(listindex - 1).change == false) {
								// 이전숫자가 지금 숫자랑 같고
								// 변화한적이 없다면,
								list.get(listindex - 1).number *= 2;
								list.get(listindex - 1).change = true;
							} else {
								// 아니면 그냥 리스트에 넣어줌
								list.add(new Node(fieldC[j][i], false));
								listindex += 1;
							}
						}
					}
				}
				// 리스트에서 배열로 옮겨주기
				for (Node X : list) {
					System.out.print(X.number + " ");
				}
				System.out.println();

				int max = list.size();
				for (int i = 0; i < N; i++) {
					if (i >= max) {
						fieldC[j][i] = 0;
					} else {
						fieldC[j][i] = list.get(i).number;
					}
				}
			}
		}

		// 배열출력해보기
		System.out.println("이동완료 .. 배열 출력");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(fieldC[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

}