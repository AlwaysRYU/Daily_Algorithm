package M10;

import java.util.Arrays;

public class com {
	static int count = 0;
	static int[] N = {1,2,3,4,5};
	static int[] R = new int[3];
	
	public static void main(String[] args) {
		combination(0,0);
		System.out.println("개수 : " + count);
	}
	
	static void combination(int N_index , int R_index) {
		if ( R_index == R.length ) {
			System.out.println(Arrays.toString(R));
			count++;
			return;
		}
		if(N_index == N.length)
			return;
		R[R_index] = N[N_index];
		combination(N_index + 1, R_index+1);
		combination(N_index + 1, R_index);
	}
}
