package dynnamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준14631로만들기 {



	
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N+1];
	
		int num3=Integer.MAX_VALUE;
		int num2=Integer.MAX_VALUE;
		
		for (int i = N-1; i > 0 ; i--) {
			
			if( i*3 <= N )
				num3 = arr[i*3]+1;
			if( i*2 <= N )
				num2 = arr[i*2]+1;

			
			arr[i] = Math.min(Math.min(num3, num2), arr[i+1]+1);
			num3=Integer.MAX_VALUE;
			num2=Integer.MAX_VALUE;
		}
		
	
		System.out.println(arr[1]);
	}
	
	
	
	
}
