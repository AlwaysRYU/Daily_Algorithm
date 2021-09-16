package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import M09.D15_컨베이어벨트위의로봇.Robot;

//https://www.acmicpc.net/problem/20055
public class D15_컨베이어벨트위의로봇2 {
	
	static class Robot{
		int index;
		public Robot(int index) {
			this.index = index;
		}
		@Override
		public String toString() {
			return "Robot [index=" + index + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] belt = new int[N *2][2];

		int zerocount = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			belt[i][0] = Integer.parseInt(st.nextToken());
			if (belt[i][0] == 0 ) zerocount += 1;
			belt[i][1] = 0;
		}
		
		System.out.println("배열출력");
		for (int i = 0; i < belt.length; i++) {
			System.out.print(" [" + belt[i][0] + "/" + belt[i][1] + "] ");
		}
		System.out.println();
		
		ArrayList<Robot> robotlist = new ArrayList<>();
		int length = 2*N;
		int time = 0;
		while(true) {
			time += 1;
			// 1. 한칸회전하기
			int lastN = belt[N*2 -1][0];
			int lastR = belt[N*2-1][1];
			for (int i = length-1; i > 0; i--) {
				belt[i][0] = belt[i-1][0];
				belt[i][1] = belt[i-1][1];
			}
			belt[0][0] = lastN;
			belt[0][1] = lastR;
			
			int deleteindex = -1;
			for (int i = 0; i < robotlist.size(); i++) {
				robotlist.get(i).index += 1;
				if (robotlist.get(i).index == length-1) {
					deleteindex = i;
				}
			}
			if (deleteindex != -1) {
				belt[length-1][1] = 0;
				robotlist.remove(deleteindex);
				System.out.println("회전하다가  하나 로봇나감!");
				
			}
			
			for (int i = 0; i < belt.length; i++) {
				System.out.print(" [" + belt[i][0] + "/" + belt[i][1] + "] ");
			}
			System.out.println(time + " : 회전함");
			
			
			// 2. 가장 먼저 벨트에 올라간 로봇 부터, 이동하면 이동한다.
			// 2. 가장 먼저 벨트에 올라간 로봇 부터, 이동하면 이동한다.
			deleteindex = -1;
			for (int i = 0; i < robotlist.size(); i++) {
				Robot now = robotlist.get(i);
				System.out.println(now.toString());
				// 다음 칸에 로봇이 없고  AND 내구도가 1이상
				if ( belt[now.index + 1][1] == 0 && belt[now.index + 1][0] >= 1) {
					belt[now.index + 1][0] -= 1; //내구도 감소
					if( belt[now.index + 1][0] == 0 ) zerocount += 1;
					
					belt[now.index][1] = 0;
					belt[now.index + 1][1] = 1;//로봇올림
					robotlist.get(i).index += 1; // 주소 바꿔주기
					
//					if(	robotlist.get(i).index == length-1) {
//						deleteindex = i;
//					}
				}
			}
			
//			if (deleteindex != -1) {
//				belt[length-1][1] = 0;
//				System.out.println("움직여서 하나 로봇나감!");
//				robotlist.remove(deleteindex);
//			}
			
			for (int i = 0; i < belt.length; i++) {
				System.out.print(" [" + belt[i][0] + "/" + belt[i][1] + "] ");
			}
			System.out.println(time + " : 로봇 이동 완료");
			
			// 3. 올리는 위치에 내구도가 0 이아니라면 로봇 올리기
			if (belt[0][1] == 0 && belt[0][0] >= 1) {
				belt[0][0] -= 1; //내구도 감소
				if(belt[0][0] == 0 ) zerocount += 1;
				belt[0][1] = 1;//로봇올림
				robotlist.add(new Robot(0));
			}
//			
			for (int i = 0; i < belt.length; i++) {
				System.out.print(" [" + belt[i][0] + "/" + belt[i][1] + "] ");
			}
			System.out.println(time + " : 시간 끝");
			System.out.println();
			if ( zerocount >= K) break;
		}
		System.out.println(time);
		
		
	}

}
