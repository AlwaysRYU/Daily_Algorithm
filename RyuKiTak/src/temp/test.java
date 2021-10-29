package temp;

import java.util.Arrays;

public class test {
	static int[] arr = new int[3];
	
	public static void main(String[] args) {
		dfs(0);
	}

	private static void dfs(int dep) {
		// TODO Auto-generated method stub
		if ( dep == 3) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int j = 1; j < 4; j++) {
			arr[dep] = j;
			dfs(dep+1);
		}
	}
}
