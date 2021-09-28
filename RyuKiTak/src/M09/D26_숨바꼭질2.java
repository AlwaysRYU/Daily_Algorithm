package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int before;
	int now;
}

public class D26_숨바꼭질2 {
	static int N, K;
	static int[] array = new int[100_001];
	static int[] count = new int[100_001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.offer(N);
		
		int time = 1;
		array[N] = -1;
		while(true) {
			if (Q.isEmpty()) break;
			int now = Q.poll();
			count[now] += 1;
			
			// 1. 한칸앞 
			if ( now + 1 < 100_001) {
				// 첫방문
				if ( array[now+1] == 0) {
					array[now+1] = time;
					Q.offer(now+1);
				} else if (array[now +1]  == time) {
					// 첫방문은 아니만, 현재시간이랑 같다면
					count[now+1] += 1;
				}
				
			}
			
			// 2. 한칸 뒤
			if ( now -1 > 0 ) {
				// 첫방문
				if ( array[now-1] == 0) {
					array[now-1] = time;
					Q.offer(now-1);
				} else if (array[now -1]  == time) {
					// 첫방문은 아니만, 현재시간이랑 같다면
					count[now-1] += 1;
				}
			}
			
			// 3. 두배로
			if ( now * 2  < 100_001 ) {
				// 첫방문
				if ( array[now * 2] == 0) {
					array[now * 2] = time;
					Q.offer(now * 2);
				} else if (array[now * 2]  == time) {
					// 첫방문은 아니만, 현재시간이랑 같다면
					count[now * 2] += 1;
				}
			}
			
			time += 1;
		}
		
		System.out.println(Arrays.toString(array));
		System.out.println(array[K]);
		System.out.println(count[K]);
		
	}

}
