package M09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D04_골드바흐의추측 {
	
	static boolean SOSU(int a) {
		for (int i = 2; i <= (a/2); i++) {
			if( a%i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if ( N == 0 ) break;
			
			int A = 2;
			int B = N -2;
			
			while (true) {
				
				
				if ( A % 2 == 1 &&  B%2 ==  1
						&& SOSU(A)  && SOSU(B) ) {
					System.out.println(N + " = " + A + " + " + B);
					break;
				}
				
				if ( B == A) {
					System.out.println("Goldbach's conjecture is wrong.");
					break;
				}
				
				
				A += 1;
				B -= 1;
			}
			
			
			
			
		}
		
		
	}

}
