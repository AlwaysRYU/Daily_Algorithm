package M09;
//acmicpc.net/problem/11057
import java.util.Scanner;

public class D28_오르막수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int nanugi = 10_007;
		
		long[][] upper = new long[1001][10];
		for (int i = 0; i <= 9; i++) {
			upper[1][i] = 1;
			// 자릿수가 1자리이면 그냥 1이다.
			// upper[A][B]
			// 자리수가 A자리, B는  첫자리수
			// upper[1][8] 1자리수에  첫자리수가 8인 오르막수 -> 8밖에없다.
		}
		
		//2부터 시작
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				// upper[i][j] 에대해
				
				for (int k = j; k < 10; k++) {
					// 예를들어,
					// _ _ _ 에서
					// 0 _ _ 이라면 여기에는 55개이다. 즉 10~1개를 다 더해야한다는말이다.
					// 이걸 코드로 표현함
					
					upper[i][j] += upper[i-1][k];
					upper[i][j] %= nanugi;
				}
				
			}
			
		}
		// 끝

//		for (int i = 1; i < 4; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(upper[i][j] + " ");
//			}
//			System.out.println();
//		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += upper[N][i];
		}
		System.out.println(answer%nanugi);
		
	}

}
