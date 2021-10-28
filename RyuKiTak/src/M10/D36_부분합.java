package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D36_부분합 {
	static int[] array;
	static int N, S;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean find = false;
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
//			System.out.println("지금 길이 " + i);
			
			for (int j = 1; j <= i; j++) {
				sum += array[j];
				
			}
			// 다음부터 계산 
			int first = 1;
			int next = i+1;
			while(true) {
				sum += array[next];
				sum -= array[first];
//				System.out.println(next + "을 더하고 " + first + "를 뺌" + "\\ 합은 " + sum);
				
				if ( sum >= S ) {
					answer = i;
					find = true;
					break;
				}
				next += 1;
				if ( next > N) break;
				first += 1;
			}
			
			if (find) break;
			
			
		}
		
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if ( answer == Integer.MAX_VALUE ) {
			bw.append( String.valueOf(0) );
		} else {
			bw.append( String.valueOf(answer) );
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
