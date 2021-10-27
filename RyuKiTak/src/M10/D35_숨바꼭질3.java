package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D35_숨바꼭질3 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,K;
	static int[] time = new int[100_001];
	static class Node implements Comparable<Node> {
		int position;
		int time;

		@Override
		public String toString() {
			return "Node [position=" + position + ", time=" + time + "]";
		}
		public Node() {}
		public Node(int position, int time) {
			this.position = position;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 100_001; i++) {
			time[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> Q = new PriorityQueue<>();
		Q.add(new Node(N,0));
		time[N] = 0;
		while( !Q.isEmpty() ) {
			
			Node now = Q.poll();
//			System.out.println("지금 위치 : " + now.position  + " // 지금 시간 : " + now.time );
			if ( now.position == K) {
				System.out.println(now.time);
				break;
			}
			
			if ( now.position + 1 < 100_001 && time[now.position + 1] > now.time+1 ) {
				time[now.position+1] = now.time + 1;
				Q.add(new Node(now.position+1 , now.time+1 ) );
			}
			if ( now.position - 1 >= 0 && time[now.position - 1] > now.time+1 ) {
				time[now.position-1] = now.time + 1;
				Q.add(new Node(now.position-1 , now.time + 1 ) );
			}
			if ( now.position * 2 < 100_001 && time[now.position * 2] > now.time ) {
				time[now.position * 2] = now.time;
				Q.add(new Node(now.position * 2 , now.time) );
			}
			
		}
		
	}

}
