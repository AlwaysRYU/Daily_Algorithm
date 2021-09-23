package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D22_이모티콘 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 초기화
		boolean[] check = new boolean[1001];
		int[] timearr = new int[1001];
		
		int time = 0;
		int clip = 0;
		Queue<int[]> Q = new LinkedList<>();
		// 화면에 이모티콘 개수 , 클립보드, 시간
		Q.add(new int[] {1,0,0});
		while(true) {
			
			
			
			int[] now = Q.poll();
//			System.out.println(Arrays.toString(now));
			
			
			if (now[0] == N) {
				time = now[2];
				break;
			}
			
//			if (check[now[0]]) continue;
//			check[now[0]] = true;
//			
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			Q.add(new int[] {now[0], now[0], now[2]+1});
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
			if (now[1] != 0) {
				Q.add(new int[] { now[0] + now[1], now[1], now[2]+1});
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if (now[0] > 2 && check[now[0]] == false) {
				Q.add(new int[] {now[0]-1, now[1], now[2]+1});
			}
			
			if(Q.isEmpty()) break;
			
		}
		System.out.println(time);
		
	}
}
