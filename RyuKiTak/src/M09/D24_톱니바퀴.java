package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15662
public class D24_톱니바퀴 {
	static int N, K;
	static boolean[] check;
	static ArrayList<int[]> wheel = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			wheel.add(new int[8]);
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				wheel.get(i)[j] = temp[j] - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++) {
				check[j] = false;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W_num =  Integer.parseInt(st.nextToken()) - 1;
			check[W_num] = true;
			//  1은 시계방향 -->
			// -1 은 반시계 방향 <--
			int d = Integer.parseInt(st.nextToken());
//			boolean clock = false;
			if (d == 1) {
				// 시계
				rotation(W_num, true);
			} else {
				// 반시계
				rotation(W_num, false);
			}
			
		}
		
		// 명령끝
		// 12시방향이 S극(1)인 톱니바퀴 개수
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if ( wheel.get(i)[0] == 1) answer += 1;
		}
		System.out.println(answer);
	}
	
	
	static void rotation(int Wheel_number, boolean direction) {
//		System.out.println(Wheel_number);
		// 좌 확인
		// 맨 왼쪽이 아니고 / 왼쪽의 톱니바퀴 우 측 지금 좌측이 다르면 돌린다.
		if ( Wheel_number > 0 && !check[Wheel_number-1]
				&& wheel.get(Wheel_number -1)[2] != wheel.get(Wheel_number)[6]) {
			check[Wheel_number-1] = true;
			rotation(Wheel_number-1, !direction );
		}
		
		// 우확인
		if ( Wheel_number < N-1 && !check[Wheel_number+1]
				&& wheel.get(Wheel_number + 1)[6] != wheel.get(Wheel_number)[2] ) {
			check[Wheel_number+1] = true;
			rotation(Wheel_number+1, !direction );	
		}
		
		// 내꺼 방향확인하고 돌리기
		// 지금 상황 int[8] 
		if (direction) {
			// 시계방향
			int last = wheel.get(Wheel_number)[7];
			for (int i = 7; i > 0; i--) {
				wheel.get(Wheel_number)[i] = wheel.get(Wheel_number)[i-1];
			}
			wheel.get(Wheel_number)[0] = last;
			
		} else {
			// 반시계
			int first = wheel.get(Wheel_number)[0];
			for (int i = 0; i<7; i++) {
				wheel.get(Wheel_number)[i] = wheel.get(Wheel_number)[i+1];
			}
			wheel.get(Wheel_number)[7] = first;
		}
		
	}

}
