package M10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1002
public class D33_터렛 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int Ax, Ay, Bx, By, AR, BR;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Ax = Integer.parseInt(st.nextToken());
			Ay = Integer.parseInt(st.nextToken());
			Bx = Integer.parseInt(st.nextToken());
			By = Integer.parseInt(st.nextToken());
			AR = Integer.parseInt(st.nextToken());
			BR = Integer.parseInt(st.nextToken());
			
			
			int answer = cal( Ax, Ay, Bx, By, AR, BR );
			bw.append(String.valueOf(answer) + "\n");
			
		}
		
		bw.flush();
		bw.close();
		
		
	}

	private static int cal(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	
		
		if(x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		} else if(distance > Math.pow(r1 + r2, 2)) {
			return 0;
		} else if(distance == Math.pow(r1 + r2, 2)) {
			return 1;
		} else if(distance < Math.pow(r2 - r1, 2)) {
			return 0;
		} else if(distance == Math.pow(r2 - r1, 2)) {
			return 1;
		} else {
			return 2;
		}
	}

}
