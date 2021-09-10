package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11723
public class D05_집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> List = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("add")) {
				
				int temp = Integer.parseInt(st.nextToken());
				if ( !List.contains(temp) ) {
					List.add(temp);	
				}
				
			} else if (order.equals("remove")) {
				
				int temp = Integer.parseInt(st.nextToken());
				if ( List.contains(temp) ) {
					List.remove(Integer.valueOf(temp));	
				}
				
			} else if (order.equals("check")) {
				
				int temp = Integer.parseInt(st.nextToken());
				if ( List.contains(temp) ) {
					System.out.println(1);	
				} else {
					System.out.println(0);
				}
				
			} else if (order.equals("toggle")) {
				
				int temp = Integer.parseInt(st.nextToken());
				if ( List.contains(temp) ) {
					List.remove(Integer.valueOf(temp));	
				} else {
					List.add(temp);
				}
				
			} else if (order.equals("all")) {
				
				List = new ArrayList<>();
				for (int j = 1; j <= 20; j++) {
					List.add(j);
				}
				
			} else if (order.equals("empty")) {
				List = new ArrayList<>();
			}
			
		}
		
		
		
	}
}
