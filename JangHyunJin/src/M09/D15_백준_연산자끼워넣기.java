package Recursive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_연산자끼워넣기 {

	static int N;
	static int number[];
	static int operator[];
	static int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		number = new int[N]; //숫자 저장
		operator = new int[4]; //연산자 저장  덧셈,뺄셈,곱셈,나눗셈의 순서
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) number[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		//백트래킹하면서 확인하기
		dfs(operator[0],operator[1],operator[2],operator[3],1,number[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int plus,int minus,int mul,int div,int cnt,int res) {
		if(cnt == N) {
			max = (res>max)?res:max;
			min = (min>res)?res:min;
		}
		
		if(plus>0) dfs(plus-1,minus,mul,div,cnt+1,res+number[cnt]);
		if(minus>0) dfs(plus,minus-1,mul,div,cnt+1,res-number[cnt]);
		if(mul>0) dfs(plus,minus,mul-1,div,cnt+1,res*number[cnt]);
		if(div>0) dfs(plus,minus,mul,div-1,cnt+1,res/number[cnt]);
	}

}
