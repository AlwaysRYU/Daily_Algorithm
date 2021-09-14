package dynnamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 백준14631로만들기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.print(recursive(n, 0));
        br.close();
	}
	public static int recursive(int value, int count) {
		if(value==1 || value==0)
			return count;
		else {
			int cal2 = recursive(value/2, count+1 + (value%2));
			int cal3 = recursive(value/3, count+1 + (value%3));
			return Math.min(cal2, cal3);
		}
	}
}
