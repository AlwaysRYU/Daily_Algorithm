package temp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 비상구탈출2 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int answer;
	static int N, peoplecount;
	static int[][] time = new int[2][19]; // 최대 이동시간은 18
	//출구
	static int[] peoplearr;
	static ArrayList<Node> exit = new ArrayList<>();
	static ArrayList<Node> people = new ArrayList<>();
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int Test = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= Test; testcase++) {
			//초기화
			answer = Integer.MAX_VALUE;
			exit.clear();
			people.clear();
			peoplecount = 0;
			
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp==1) {
						// 사람
						people.add(new Node(i,j));
						peoplecount += 1;
						
					} else if ( temp == 2) {
						// 비상구
						exit.add(new Node(i,j));
					}
				}
			}
			
			// 조합시작
			
			peoplearr = new int[peoplecount];
			set(0);
			
			
			bw.append("#" + testcase + " " + answer + "\n");
			
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static void set(int depth) {
		
		if ( depth == peoplecount) {
			System.out.println(Arrays.toString(peoplearr));
			
			// 초기화
			
			int totaltime = 0;
			// 2. 뽑았으면 각 사람마다 이동시간, 탈출시간 계산해서 배열에 넣기
			for (int i = 0; i < peoplecount; i++) {
				
				// 현재 이사람이 갈 비상구
				Node P = people.get(i);
				Node E = exit.get(peoplearr[i]);
				int movetime = Math.abs(P.x - E.x) + Math.abs(P.y - E.y);
				time[peoplearr[i]][movetime] += 1;
			}
			// 토탈 시간 과 함수
			System.out.println(Arrays.toString(time[0]));
			System.out.println(Arrays.toString(time[1]));
			for (int i = 1; i < 19; i++) {
				int TTT = 0;
				if ( time[0][i]!=0 || time[1][i]!=0 ) {
					TTT = i + time[0][i] + time[1][i];
					totaltime = Math.max(TTT , totaltime);
					
				} 
				time[0][i] = 0;
				time[1][i] = 0;
				
			}
			
			System.out.println("총걸린시간 : " + totaltime);
			System.out.println();
			// 3. 
			answer = Math.min(totaltime, answer);
			return;
		}
		
		peoplearr[depth] = 0;
		set(depth+1);
		peoplearr[depth] = 1;
		set(depth+1);
		
		
	}

}
