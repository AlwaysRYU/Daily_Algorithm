package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11723
public class D05_집합2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] original = new boolean[21];
		for (int i = 0; i < original.length; i++) {
			original[i] = true;
		}
		
		boolean[] arr = new boolean[21];
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("add")) {
				int temp = Integer.parseInt(st.nextToken());
				if (!arr[temp]) {
					arr[temp] =true;
				}
			} else if (order.equals("remove")) {
				
				int temp = Integer.parseInt(st.nextToken());
				if (arr[temp]) arr[temp] = false;
				
			} else if (order.equals("check")) {
				
				int temp = Integer.parseInt(st.nextToken());
				if ( arr[temp] ) System.out.println(1);
				else System.out.println(0);
				
			} else if (order.equals("toggle")) {
				
				int temp = Integer.parseInt(st.nextToken());
				arr[temp] = !arr[temp];
				
			} else if (order.equals("all")) {
				
				arr = original.clone();
				
			} else if (order.equals("empty")) {
				arr = new boolean[21];
			}
			
		}
		
		
		
	}
}
