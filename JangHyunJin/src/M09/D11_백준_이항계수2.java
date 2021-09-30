package mathAlgo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_이항계수2 {
	static int[][] memory;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		memory = new int[n+1][k+1];
		System.out.println(combination(n, k));
	}

	public static int combination(int n, int k) {
		if (n == k || k == 0) {
			memory[n][k] = 1;
			return 1;
		}

		if (memory[n][k] != 0) {
			return memory[n][k];
			

		}else {
			return memory[n][k] =( combination(n - 1, k)%10007	 + combination(n - 1, k - 1)%10007)%10007;
		}
	}

}
