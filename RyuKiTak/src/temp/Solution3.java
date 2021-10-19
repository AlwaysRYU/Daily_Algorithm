package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
	static int N;
	static long answer;
	static boolean[] build;
	
	public static void main(String args[]) throws Exception {
		// 기본 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		int Test = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Test; tc++) {
			
			N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			// 초기화
			answer = 0;
			build = new boolean[N];
			
			// 연산
			subway(false, array,0);
			
			
			// 정답 제출
			bw.append("#" + tc + " " + answer + "\n") ;
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	
	}

	private static void subway(boolean once, int[] array, long now_tadang) {
		
		// 1. 인접 불가
		
		// 2. 인접 출발 / 도착 불가
		
		// 3. 같은역 출발/도착불가
		
		int length = array.length -2;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if ((Math.abs(i-j) <= 1) || (Math.abs(i-j) == array.length-1 )) continue;
				if ( build[i] || build[j] ) continue;
				
				if (once) {
					// 지금 한번 한상태라면
					
					answer = Math.max(answer, now_tadang + tadangdo(array[i], array[j]));
				} else {
					// 아니라면
					System.out.println(i + " --- " + j + " 둘 철도 이음" );
					 
					// 배열을 둘로 나누기
					// 안쪽
					if (j-i >= 6) {
						int[] subarray = new int[j-i-4];
						for (int k = i+2; k < subarray.length; k++) {
							subarray[k] = array[k];
						}
						System.out.println("안쪽 : " + Arrays.toString(subarray));
						subway(true, subarray, tadangdo(array[i], array[j]));
							
					}
					// 바깥쪽if (j-i >= 6) {
					if ( i-2 + (array.length-j) >= 6) {
						int[] subarray2 = new int[i + (array.length-j)];
						for (int count = 0; count < j-i-4; count++) {
							int index = (j + 2 + count) % array.length;
							subarray2[index] = array[index];
						}

						System.out.println("바깥쪽 : " + Arrays.toString(subarray2));
						subway(true, subarray2, tadangdo(array[i], array[j]));
					}
					
				} // 배열종료
				
			}
			
		}
		
		
		// 4. 만약 true 라면 최대 앤서 계산, 아니면  나눠서 재귀 돌리기
		
		
	}
	
	static long tadangdo(int a, int b) {
		return (a+b) * (a+b);
		
	}

}
