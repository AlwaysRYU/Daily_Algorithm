package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D36_부분합_2트 {
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
		
		int Sum = 0;
		int next = 1;
		int before = 1;
		while(true) {
			if ( Sum >= S ) {
				Sum -= array[before];
				answer = Math.min(answer, (next-before));
				before += 1;
			} else if ( next == N+1) {
				break;
			} else {
				Sum += array[next];
				next += 1;
			}
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
