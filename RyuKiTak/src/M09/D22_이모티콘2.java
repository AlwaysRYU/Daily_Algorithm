package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class IMTI {
	int clip = 0;
	int On = 0;
	int time = 0;
	
	public IMTI(int clip, int on, int time) {
		this.clip = clip;
		this.On = on;
		this.time = time;
	}

	@Override
	public String toString() {
		return "IMTI [clip=" + clip + ", On=" + On + ", time=" + time + "]";
	}
	
	
}
public class D22_이모티콘2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 초기화
		boolean[][] check = new boolean[1001][1001];
		
		Queue<IMTI> Q = new LinkedList<>();
		Q.offer(new IMTI(0,1,0));
		check[0][1] = true;
		
		while(true) {
			if (Q.isEmpty()) break;
			IMTI now = Q.poll();
			
			if (now.On == N) {
				System.out.println(now.time);
				return;
			}
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			Q.offer(new IMTI(now.On, now.On, now.time+1 ));
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
			if (now.clip != 0 && now.On + now.clip <= N
					&& !check[now.clip][now.On + now.clip] ) {
				check[now.clip][now.On + now.clip] = true;
				Q.offer(new IMTI(now.clip, now.On + now.clip, now.time+1 ));
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if ( 1<= now.On
					&& !check[now.clip][now.On -1] ) {

				check[now.clip][now.On -1] = true;
				Q.offer(new IMTI(now.clip, now.On -1, now.time+1 ));
			}
			
			
		}
		
	}
}
