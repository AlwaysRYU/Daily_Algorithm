package M10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12920
public class D06_평범한배낭2 {
	static int N, M;
	static int[][] arr;
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물건 종류의 수
		M = Integer.parseInt(st.nextToken()); // 들 수 있는최고의 무게
		
		list.add(new int[M+1]);
		int Xindex = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int Value = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // 물건의 개수 
			
			for (int j = 0; j < K; j++) {
				list.add(new int[M+1]);
				for (int yy = 1; yy <= M; yy++) {
					list.get(i+j)[yy] = list.get(i+j-1)[yy];
					if ( (yy-weight) >= 0 ) {
						list.get(i+j)[yy] = Math.max(list.get(i+j)[yy], list.get(i+j-1)[yy - weight] + Value );
					}
				}
				Xindex += 1;
			}
			
		}
		
//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		for(int[] x : list) {
			System.out.println(Arrays.toString(x));
		}
		
		
	}

}
