package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_5014 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer[]> q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[N + 1];
		q.offer(new Integer[] { S, 0 });
		check[S] = true;
		
		Integer[] data = null;
		while (!q.isEmpty()) {
			data = q.poll();
			
			if (data[0] == G) break;
			
			int nextPos = data[0] + U;
			int nextSec = data[1] + 1;
			if (1 <= nextPos && nextPos <= N && !check[nextPos]) {
				q.offer(new Integer[] { nextPos, nextSec });
				check[nextPos] = true;
			}
			nextPos = data[0] - D;
			if (1 <= nextPos && nextPos <= N && !check[nextPos]) {
				q.offer(new Integer[] { nextPos, nextSec });
				check[nextPos] = true;
			}
		}
		
		if (data[0] == G) {
			System.out.println(data[1]);
		} else {
			System.out.println("use the stairs");
		}
	}
}
