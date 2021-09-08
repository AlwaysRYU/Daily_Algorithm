package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11404

public class D03_행성터널 {
	static int N, M;
	static planet[] list;
	static class planet {
		int x;
		int y;
		int z;
		
		public planet(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static class V implements Comparable<V>{
		int cost;
		int start;
		int end;
		public V(int cost, int start, int end) {
			super();
			this.cost = cost;
			this.start = start;
			this.end = end;
		}
			
		@Override
		public int compareTo(V x) {
			int result = Integer.compare(cost, x.cost);
			return result;
		}

		@Override
		public String toString() {
			return "V [cost=" + cost + ", start=" + start + ", end=" + end + "]";
		}
		
	}
	
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
//		list = new planet[N];
		parent = new int[N+1];
//		
		
		// X리스트, Y리스트 , Z리스트
		// 조건이 min임으로 이렇게 계산할 수 있다.
//		ArrayList<int[]> Xlist = new ArrayList<>();
//		ArrayList<int[]> Ylist = new ArrayList<>();
//		ArrayList<int[]> Zlist = new ArrayList<>();
		
		int[][] Xlist = new int[N+1][2];
		int[][] Ylist = new int[N+1][2];
		int[][] Zlist = new int[N+1][2];
		
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine());
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			int zz = Integer.parseInt(st.nextToken());
			Xlist[i][0] = xx;
			Xlist[i][1] = i;
			Ylist[i][0] = yy;
			Ylist[i][1] = i;
			Zlist[i][0] = zz;
			Zlist[i][1] = i;
//			Xlist.add(new int[] {xx, i});
//			Ylist.add(new int[] {yy, i});
//			Zlist.add(new int[] {zz, i});
		}
		
		Arrays.sort(Xlist, new Comparator<int[]>() {
			@Override	
			public int compare(int[] t1, int[] t2) {
				return t1[0] - t2[0];
			}
		});
		Arrays.sort(Ylist, new Comparator<int[]>() {
			@Override	
			public int compare(int[] t1, int[] t2) {
				return t1[0] - t2[0];
			}
		});
		Arrays.sort(Zlist, new Comparator<int[]>() {
			@Override	
			public int compare(int[] t1, int[] t2) {
				return t1[0] - t2[0];
			}
		});
		
//		Collections.sort(Xlist);
//		Collections.sort(Ylist);
//		Collections.sort(Zlist);
		
		// 간선리스트
		ArrayList<V> Vlist = new ArrayList<>();
		int result = 0;
		int answer = 0; // 답		
		for (int i = 1; i < N; i++) {
			Vlist.add(new V(Xlist[i+1][0] - Xlist[i][0], Xlist[i][1], Xlist[i+1][1]));
			Vlist.add(new V(Ylist[i+1][0] - Ylist[i][0], Ylist[i][1], Ylist[i+1][1]));
			Vlist.add(new V(Zlist[i+1][0] - Zlist[i][0], Zlist[i][1], Zlist[i+1][1]));
		}
		Collections.sort(Vlist);
		
		for(V x : Vlist) {
//			System.out.println(x.toString());
			int nowCost = x.cost;
			int nowA = x.start;
			int nowB = x.end;
			
			if (find_parent(parent, nowA) != find_parent(parent, nowB)) {
//				System.out.println("사이클이 발생하지않음");
				union_parent(parent, nowA, nowB);
				result += nowCost;
			}
		}
		System.out.println(result);
		
	}
	
	static int find_parent(int[] parent, int x) {
		if (parent[x] != x)
			parent[x] = find_parent(parent, parent[x]);
		return parent[x];
	}
	static void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		if ( a< b) parent[b] = a;
		else parent[a] = b;
	}

}
