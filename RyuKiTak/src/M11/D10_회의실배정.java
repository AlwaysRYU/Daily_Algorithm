package M11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D10_회의실배정 {
	static int answer = 0; // 최대 회의 개수
	
	static class Node implements Comparable<Node> {
		int start;
		int end;
		public Node(int x, int y) {
			this.start = x;
			this.end = y;
		}
		
		@Override
		public int compareTo(Node o) {
			if ( this.end == o.end ) {
				return this.start - o.start;
			} else {
				return this.end - o.end;
			}
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	//static PriorityQueue<Node> PQ = new PriorityQueue<>( (e1,e2) -> e1.end - e2.end );
	static PriorityQueue<Node> PQ = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			PQ.add(new Node(start,end));
		}
		
		Node first = PQ.poll();
		int nowST = first.start;
		int nowED = first.end;
		while( PQ.isEmpty() == false ) {
			Node now = PQ.poll();
			//System.out.println(now.toString());
			
			if ( now.start >= nowED ) {
				// 이경우만 할 수 있다.
				nowED = now.end;
				answer += 1;
			}
		}
		
		System.out.println(answer + 1);
		
	}

}
