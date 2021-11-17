package M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7562
public class D17_나이트의이동 {
	static int N;
	static int[][] field;
	static class Node {
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int dx[] = { -1,1,2, 2, 1,-1,-2,-2};
		int dy[] = {  2,2,1,-1,-2,-2,-1, 1};
		
		
		int Test = Integer.parseInt(br.readLine());
		for (int ttt = 0; ttt < Test; ttt++) {
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			
			Queue<Node> Q = new LinkedList<>();
			Q.add(new Node(x,y,1));
			field[x][y] = 1;
			
			while( !Q.isEmpty() ) {
				Node now = Q.poll();
				if (now.x == fx && now.y == fy ) {
					bw.append(Integer.toString(now.count -1)+"\n");
					break;
				}
				for (int i = 0; i < 8; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if (nx<0 || ny<0 || nx>= N || ny>= N 
							|| field[nx][ny] != 0) {
						continue;
					}
					
					field[nx][ny] = now.count+1;
					
					Q.add(new Node(nx,ny,now.count+1));
					
					
				}
			}
			
		
		}
		
		bw.flush();
		br.close();
		bw.close();
		
		
		
		
		
		
	}

}
